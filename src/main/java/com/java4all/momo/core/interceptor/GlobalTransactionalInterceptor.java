package com.java4all.momo.core.interceptor;

import com.java4all.momo.annotation.GlobalTransactional;
import com.java4all.momo.core.GlobalTransaction;
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
        if(globalTransactional != null){

        }

//TODO
        return null;
    }
    private GlobalTransactional getGlobalTransactional(Method method){
        boolean globalTransactional = method.isAnnotationPresent(GlobalTransactional.class);
        if(globalTransactional){
        //we need add get some info from this to add into globalTransaction defination
            return method.getAnnotation(GlobalTransactional.class);
        }else {
            return null;
        }
    }
}
