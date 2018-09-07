package xiaoxiong.blog.exceptions;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/4
 */
public class UserException extends RuntimeException {

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}
