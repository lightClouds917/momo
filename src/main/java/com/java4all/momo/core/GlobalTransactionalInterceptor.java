package com.java4all.momo.core;

import com.java4all.momo.annotation.GlobalTransactional;
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

        GlobalTransactional globalTransactional = this
                .getGlobalTransactional(methodInvocation.getMethod());

//TODO
        return null;
    }
    private GlobalTransactional getGlobalTransactional(Method method){
        boolean globalTransactional = method.isAnnotationPresent(GlobalTransactional.class);
        if(globalTransactional){
            return method.getAnnotation(GlobalTransactional.class);
        }else {
            return null;
        }
    }
}
