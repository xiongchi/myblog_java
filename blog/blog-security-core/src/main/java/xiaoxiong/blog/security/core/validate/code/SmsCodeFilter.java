package xiaoxiong.blog.security.core.validate.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import xiaoxiong.blog.security.core.properties.SecurityProperties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static xiaoxiong.blog.security.core.constants.ResultCode.*;
import static xiaoxiong.blog.security.core.constants.SecurityConstants.SEESION_KEY;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/10
 *
 * 验证密码 过滤器  OncePerRequestFilter 只会调用一次
 *
 * InitializingBean 接口 可实现在创建对象之前 或者之后 对bean 进行操作
 */
public class SmsCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    // 初始化需要验证码
    private Set<String> urls = new HashSet<>();

    private SecurityProperties securityProperties;

    //路径匹配器
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     *  完成bean创建之后
     * @throws ServletException
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configurls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getSmsCode().getUrls(), ",");
        //配置那些url需要验证码
        if(configurls != null){
            for(String configUrl : configurls){
                urls.add(configUrl);
            }
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;

        for(String url : urls){
            //解决url/*等 这些路径问题
            if(pathMatcher.match(url, httpServletRequest.getRequestURI())){
                action = true;
            }
        }

        if(action){
            try{
                validate(new ServletWebRequest(httpServletRequest));
            }catch (ValidateCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException, ValidateCodeException {
        ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(request, SEESION_KEY);

        //从请求参数中找到对应smsCode
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "smsCode");

        if(StringUtils.isBlank(codeInRequest)){
            throw new ValidateCodeException(VALIDATE_NULL);
        }

        if(null == codeInRequest){
            throw new ValidateCodeException(VALIDATE_NOT_FIND);
        }

        if(codeInSession.isExpried()){
            throw new ValidateCodeException(VALIDATE_EXPRIED);
        }

        if(!StringUtils.equals(codeInSession.getCode(), codeInRequest)){
            throw new ValidateCodeException(VALIDATE_NOT_MATCH);
        }

    }
}
