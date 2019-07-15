package com.java4all.momo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The aspect
 * @author IT云清
 * @date 2019年07月15日 18:58:45
 * @since V1.0.0
 */
@Aspect
public class GlobalTransactionalAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            GlobalTransactionalAspect.class);

    @Pointcut("@annotation(com.java4all.momo.annotation.GlobalTransactional)")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeExecute(JoinPoint joinPoint){

    }

    @AfterReturning("pointCut()")
    public void afterExecute(JoinPoint joinPoint){

    }
}
