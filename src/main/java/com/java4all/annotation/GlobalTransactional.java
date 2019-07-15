package com.java4all.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface of Global transactional
 * @author IT云清
 * @date 2019年07月14日 22:35:31
 * @since V1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GlobalTransactional {
    /**
     * 是否是分布式事务发起方  true 分布式事务发起方， false 非发起方
     * @return
     * @version 1.0.0
     */
    boolean isStart() default false;
}
