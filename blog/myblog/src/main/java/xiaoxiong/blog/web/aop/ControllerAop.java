package xiaoxiong.blog.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class ControllerAop {

    //处理跨域Post请求
    @Around("execution (* xiaoxiong.blog.web.controller..*.*(..))")
    public Object testAop(ProceedingJoinPoint pro) throws Throwable {
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
