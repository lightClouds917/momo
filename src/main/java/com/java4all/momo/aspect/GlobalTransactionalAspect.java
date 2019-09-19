package com.java4all.momo.aspect;

import static com.java4all.momo.constant.TransactionInfoConstant.DEFAULT_TIME_OUT;
import static com.java4all.momo.constant.TransactionInfoConstant.EMPTY_STRING;
import static com.java4all.momo.constant.TransactionInfoConstant.SEMICOLON_SPLIT;

import com.java4all.momo.annotation.GlobalTransactional;
import com.java4all.momo.request.branch.BranchRegistRequest;
import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.util.UUIDGenerator;
import java.lang.reflect.Method;
import java.time.LocalDate;
import org.aspectj.lang.JoinPoint;
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

        boolean isStart = this.isStart(joinPoint);

        //判断是否是事务发起方
        if(isStart){
            //创建全局事务
            StringBuffer sb = new StringBuffer();
            //TODO 怎么生成和获取
            String groupId = "11111";
            String xid = new StringBuffer()
                    .append(groupId)
                    .append(SEMICOLON_SPLIT)
                    .append(LocalDate.now().toString())
                    .append(UUIDGenerator.generateUUID())
                    .toString();
            GlobalBeginRequest request = new GlobalBeginRequest();
            request.setTransactionName(name(joinPoint));
            request.setTimeout(defaultTimeMills(joinPoint));
            request.setXid(xid);
            //TODO 发送给server
        }else {
            //创建分支事务
            //获取全局事务id  //TODO 如何从事务上下文中获取和设置
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
     * get global transaction name
     * @param joinPoint
     * @return
     */
    private String name(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method.isAnnotationPresent(GlobalTransactional.class)){
            GlobalTransactional globalTransactional = method.getAnnotation(GlobalTransactional.class);
            return globalTransactional.name();
        }else {
            return EMPTY_STRING;
        }
    }

    /**
     * get global transaction defaultTimeMills
     * @param joinPoint
     * @return
     */
    private int defaultTimeMills(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method.isAnnotationPresent(GlobalTransactional.class)){
            GlobalTransactional globalTransactional = method.getAnnotation(GlobalTransactional.class);
            return globalTransactional.defaultTimeMills();
        }else {
            return DEFAULT_TIME_OUT;
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
