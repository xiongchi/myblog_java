package xiaoxiong.blog.handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xiaoxiong.blog.exceptions.AuthenticationException;
import xiaoxiong.blog.result.ResultMsg;
import xiaoxiong.blog.utils.ResultUtil;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ResultMsg authenticationExceptionHandler(Exception e){
        return ResultUtil.error(403, e.getMessage());
    }

}
