package xiaoxiong.blog.exceptions;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public class ParamErrorException extends Exception {

    public ParamErrorException() {
        super("传入参数异常");
    }

    public ParamErrorException(String message) {
        super("异常参数-----" + message);
    }

}
