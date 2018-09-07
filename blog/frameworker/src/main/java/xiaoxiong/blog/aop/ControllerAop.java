package xiaoxiong.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class ControllerAop {


    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void controllerPointCut(){
    }

//    /**
//     * 处理参数验证
//     * @param pro
//     */
//    @Before("controllerPointCut()")
//    public void validateController(JoinPoint pro){
//        // 获取方法信息
//        MethodSignature signature = (MethodSignature) pro.getSignature();
//        Method method = signature.getMethod();
//        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
//    }

    //处理跨域GET请求
    @Around("controllerPointCut()")
    public Object JsonpAop(ProceedingJoinPoint pro) throws Throwable {
        //获取response
        HttpServletResponse response = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getResponse();
        //核心设置
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader( "Access-Control-Allow-Methods", "*" );
        response.addHeader( "Access-Control-Max-Age", "1000" );
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setContentType( "application/json; charset=utf-8" );
        //执行调用的方法
        Object proceed = pro.proceed();
        return proceed;
    }


}
