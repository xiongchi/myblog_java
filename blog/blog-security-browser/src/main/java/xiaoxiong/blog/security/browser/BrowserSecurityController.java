package xiaoxiong.blog.security.browser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xiaoxiong.blog.security.core.constants.SecurityConstants;
import xiaoxiong.blog.security.browser.support.SimpleResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/27
 */
@RestController
public class BrowserSecurityController {

    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        return new SimpleResponse(401,"访问的服务需要身份认证，请引导用户到登录页");
    }

}
