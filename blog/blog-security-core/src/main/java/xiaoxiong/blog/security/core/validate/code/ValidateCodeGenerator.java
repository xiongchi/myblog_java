package xiaoxiong.blog.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/10
 */
public interface ValidateCodeGenerator {
    ValidateCode generator(ServletWebRequest request);
}
