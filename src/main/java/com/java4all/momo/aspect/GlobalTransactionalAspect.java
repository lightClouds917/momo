package com.java4all.momo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * The aspect
 * @author IT云清
 * @since V1.0.0
 */
@Aspect
@Component
public class GlobalTransactionalAspect implements Ordered{
    private static final Logger LOGGER = LoggerFactory.getLogger(
            GlobalTransactionalAspect.class);

    @Pointcut("@annotation(com.java4all.momo.annotation.GlobalTransactional)")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeExecute(JoinPoint joinPoint){

        //获取连接
        //开启事务
        //执行操作
        //wait .......
        //判断所有分支事务的状态
        //提交/回滚
    }

    @AfterReturning("pointCut()")
    public void afterExecute(JoinPoint joinPoint){

    }

    /**
     * 本地事务和全局事务优先级区分
     * @return
     */
    @Override
    public int getOrder() {
        //TODO 大还是小
        return 10000;
    }
}
