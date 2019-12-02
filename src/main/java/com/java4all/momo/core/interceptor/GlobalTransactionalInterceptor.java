package com.java4all.momo.core.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Global Transactional Interceptor
 * @author ITyunqing
 * @version V1.0.0
 */
public class GlobalTransactionalInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {


//TODO
        return null;
    }

    private <T extends Annotation> T getAnnotation(Method method,Class<T> clazz){
        return method == null ? null : method.getAnnotation(clazz);
    }
}
