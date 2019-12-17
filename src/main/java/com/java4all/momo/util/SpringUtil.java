package com.java4all.momo.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ITyunqing
 */
@SuppressWarnings("all")
public class SpringUtil {

    /**
     * from seata
     * @param bean
     * @return
     */
    public static Class<?>[] getAllInterfaces(Object bean) {
        Set<Class<?>> interfaces = new HashSet<>();
        if (bean != null) {
            Class<?> clazz = bean.getClass();
            while (!Object.class.getName().equalsIgnoreCase(clazz.getName())) {
                Class<?>[] clazzInterfaces = clazz.getInterfaces();
                interfaces.addAll(Arrays.asList(clazzInterfaces));
                clazz = clazz.getSuperclass();
            }
        }
        return interfaces.toArray(new Class[0]);
    }


    /**
     * get all interfaces of a bean
     * @param bean the bean
     * @return interfaces
     */
    public static Class<?>[] getAllInterfacesDeep(Object bean){
        Set<Class<?>> result = new HashSet<>();
        if(bean != null){
            getAllClazz(bean.getClass(),result);
        }
        result = result.stream().filter(clazz -> clazz.isInterface()).collect(Collectors.toSet());
        return result.toArray(new Class[0]);
    }

    /**
     * get all supper clazz
     * @param clazz  the clazz
     * @param superClazzList  the superInterfaces list
     */
    public static void getAllClazz(Class<?> clazz, Set<Class<?>> superClazzList) {
        if (clazz == null) {
            return;
        }
        if(!superClazzList.contains(clazz)
                && !Object.class.getName().equalsIgnoreCase(clazz.getName())){
            superClazzList.add(clazz);
            Class<?> superclass = clazz.getSuperclass();
            getAllClazz(superclass,superClazzList);
            Class<?>[] interfaces = clazz.getInterfaces();
            for(Class<?> interfaceClazz:interfaces){
                getAllClazz(interfaceClazz,superClazzList);
            }
        }
    }

}
