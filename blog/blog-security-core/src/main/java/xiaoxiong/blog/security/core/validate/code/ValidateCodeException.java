package xiaoxiong.blog.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/18
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
