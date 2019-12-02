package com.java4all.momo.core.interceptor;

import com.java4all.momo.annotation.GlobalTransactional;
import com.java4all.momo.core.GlobalTransaction;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;

/**
 * Global Transactional Interceptor
 * @author ITyunqing
 * @version V1.0.0
 */
public class GlobalTransactionalInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //TODO 去了解
        Class<?> targetClass = (methodInvocation.getThis()) == null ? null
                : AopUtils.getTargetClass(methodInvocation.getThis());
        Method mostSpecificMethod = ClassUtils
                .getMostSpecificMethod(methodInvocation.getMethod(), targetClass);
        final Method method = BridgeMethodResolver.findBridgedMethod(mostSpecificMethod);
        final GlobalTransactional globalTransactional = this.getAnnotation(method, GlobalTransactional.class);
        if(globalTransactional != null){

        }else {
            methodInvocation.proceed();
        }


        return null;
    }

    private <T extends Annotation> T getAnnotation(Method method,Class<T> clazz){
        return method == null ? null : method.getAnnotation(clazz);
    }
}
