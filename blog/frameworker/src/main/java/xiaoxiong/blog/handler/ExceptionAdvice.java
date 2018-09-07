package xiaoxiong.blog.handler;


import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xiaoxiong.blog.exceptions.AuthenticationException;
import xiaoxiong.blog.exceptions.ParamErrorException;
import xiaoxiong.blog.exceptions.UserException;
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

    @ExceptionHandler(value = BindException.class)
    public ResultMsg validateException(BindException e){
        BindingResult bindingResult = e.getBindingResult();
        String errorMsg = bindingResult.getFieldError().getDefaultMessage();
        if(StringUtils.isEmpty(errorMsg)){
            errorMsg = "参数错误, 请检查";
        }
        return ResultUtil.error(300, errorMsg);
    }

    @ExceptionHandler(value = ParamErrorException.class)
    public ResultMsg paramErrorException(ParamErrorException e){
        return ResultUtil.error(300, e.getMessage());
    }

    @ExceptionHandler(value = UserException.class)
    public ResultMsg userException(UserException e){
        return ResultUtil.error(301, e.getMessage());
    }

}
