package xiaoxiong.blog.aop;


import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xiaoxiong.blog.annotations.ControlLog;
import xiaoxiong.blog.annotations.MethodLog;

import java.lang.reflect.Method;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/21
 */
@Aspect
@Component
public class LogAop {

    private static Logger log = LoggerFactory.getLogger(LogAop.class);


    @Pointcut("@annotation(xiaoxiong.blog.annotations.ControlLog)")
    public void controllerLogPointCut(){
    }

    @Pointcut("@annotation(xiaoxiong.blog.annotations.MethodLog)")
    public void methodLogPointCut(){

    }

    @Before("methodLogPointCut()")
    public void methodLogBefore(JoinPoint joinPoint){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MethodLog annotation = method.getAnnotation(MethodLog.class);
        if (!hasPageable(method)){
            log.info("{}--开始\n class:{}-----method:{}----params:{}", annotation.value(),
                    method.getDeclaringClass().getName(), method.getName(), JSONObject.toJSONString(method.getParameters()));
        }else{
            log.info("{}--开始\n class:{}-----method:{}", annotation.value(), method.getDeclaringClass().getName(), method.getName());
        }
    }

    //参数为Pageable时 JsonObject转换出错
    private boolean hasPageable(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class clazz : parameterTypes){
            if(clazz.getTypeName().equals("org.springframework.data.domain.Pageable")){
                return true;
            }
        }
        return false;
    }

    @Around("controllerLogPointCut()")
    public Object controllerLogAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature sign =  (MethodSignature)pjp.getSignature();
        Method method = sign.getMethod();
        ControlLog annotation = method.getAnnotation(ControlLog.class);
        // 记录开始时间
        long start = System.currentTimeMillis();
        Object[] args = pjp.getArgs();
        log.info("{}请求报文：{}",annotation.value(), JSONObject.toJSONString(args));

        Object result = pjp.proceed();
        log.info("{}返回报文：{}", annotation.value(), JSONObject.toJSONString(result));
        // 获取执行完的时间
        log.info("{}执行时长{}s", annotation.value(),(System.currentTimeMillis() - start)/1000.0);
        return result;
    }

    @AfterReturning(pointcut = "methodLogPointCut()", returning = "result")
    public void methodLogAfter(JoinPoint joinPoint, Object result){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MethodLog annotation = method.getAnnotation(MethodLog.class);
        log.info("{} --结束 返回值:{}", annotation.value(), JSONObject.toJSONString(result));
    }



}
