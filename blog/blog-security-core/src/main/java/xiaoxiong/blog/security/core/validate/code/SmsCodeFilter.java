package xiaoxiong.blog.security.core.validate.code;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}
