package xiaoxiong.blog.security.core.constants;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/29
 */
public interface ResultCode {

    int NO_LOGIN = 200;

    String VALIDATE_NULL = "验证码的值不能为空";

    String VALIDATE_NOT_FIND = "验证码不存在";

    String VALIDATE_EXPRIED = "验证码已过期";

    String VALIDATE_NOT_MATCH = "验证码不匹配";
}
