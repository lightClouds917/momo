package com.java4all.momo.aspect;

import com.java4all.momo.connection.ConnectionProxy;
import java.sql.Connection;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 接管Spring的数据库连接
 * @author IT云清
 * @date 2019年07月16日 20:21:19
 */
@Aspect
@Component
public class DataSourceAspect {

    @Around("execution(* javax.sql.DataSource.getConnection(..))")
    public Connection arount(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = (Connection) joinPoint.proceed();
        return new ConnectionProxy(connection);
    }

}
