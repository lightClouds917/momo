package com.java4all.momo.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ITyunqing
 */
public class SpringUtil {

    public static Class<?>[] getAllInterfaces(Object bean){
        Set<Class<?>> classes = new HashSet<>();
        if(bean != null){
            Class<?> clazz = bean.getClass();

            while(!Object.class.getName().equalsIgnoreCase(clazz.getName())){
                Class<?>[] interfaces = clazz.getInterfaces();
                classes.addAll(Arrays.asList(interfaces));
                clazz = clazz.getSuperclass();
            }
        }
        return classes.toArray(new Class[0]);
    }
}
