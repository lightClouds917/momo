package com.java4all.momo.aspect;

import com.java4all.momo.annotation.GlobalTransactional;
import com.java4all.momo.request.BranchRegistRequest;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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

        boolean start = this.isStart(joinPoint);

        //判断是否是事务发起方
        if(start){
            //创建全局事务
            String groupId = "11111";
        }else {
            //创建分支事务
            //获取全局事务id
            BranchRegistRequest branchRegistRequest = new BranchRegistRequest();
            branchRegistRequest.setXid("");
            branchRegistRequest.setApplicationData("");
            branchRegistRequest.setResourceId("");
        }

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
     * is transaction starter
     * @param joinPoint
     * @return
     */
    private boolean isStart(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(GlobalTransactional.class)){
            GlobalTransactional globalTransactional = method.getAnnotation(GlobalTransactional.class);
            return globalTransactional.isStart();
        }else {
            return false;
        }
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
