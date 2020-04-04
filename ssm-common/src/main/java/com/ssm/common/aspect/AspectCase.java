package com.ssm.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/4 21:59
 * @description:
 */
@Slf4j
@Aspect
@Component
public class AspectCase {

    @Pointcut("@annotation(com.ssm.common.aspect.AnnotationControllerCase)")
    public void controllerAspect() {

    }

    @Around(value = "controllerAspect() && @annotation(AnnotationControllerCase)")
    public Object controllerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("测试 Controller 层切面是否生效....");
        Object object = joinPoint.proceed(args);
        log.info("Controller 切面已经生效.....");
        return object;
    }


    @Pointcut("@annotation(com.ssm.common.aspect.AnnotationServiceCase)")
    public void serviceAspect() {

    }

    @Around(value = "serviceAspect() && @annotation(AnnotationServiceCase)")
    public void serviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("测试 Service 层切面是否生效....");
        joinPoint.proceed(args);
        log.info("Service 切面已经生效.....");
    }

}
