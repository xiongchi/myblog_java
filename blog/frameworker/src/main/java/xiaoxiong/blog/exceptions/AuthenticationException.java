package xiaoxiong.blog.exceptions;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("身份验证错误");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
