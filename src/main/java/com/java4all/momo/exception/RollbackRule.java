package com.java4all.momo.exception;

import java.io.Serializable;
import org.springframework.util.StringUtils;

/**
 * @author ITyunqing
 */
public class RollbackRule implements Serializable{

    private final String exceptionName;

    public int getDepth(Throwable ex){
        return getDepth(ex.getClass(),0);
    }


    /**
     * Recursive lookup
     * @param exceptionClass
     * @param depth
     * @return
     */
    private int getDepth(Class<?> exceptionClass,int depth){
        if(exceptionClass.getName().contains(this.exceptionName)){
            return depth;
        }
        if(exceptionClass == Throwable.class){
            return -1;
        }
        return getDepth(exceptionClass.getSuperclass(),depth + 1);
    }



    public RollbackRule(Class<?>clazz){
        if(clazz == null){
            throw new NullPointerException("class can not be null");
        }
        if(!Throwable.class.isAssignableFrom(clazz)){
            throw new IllegalArgumentException("can not construct rollback rule from ["+clazz+"]."
                    + "It is not a Throwable");
        }
        this.exceptionName = clazz.getName();
    }


    public RollbackRule(String exceptionName) {
        if(StringUtils.isEmpty(exceptionName)){
            throw new IllegalStateException("exceptionName can not be null or empty");
        }
        this.exceptionName = exceptionName;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    @Override
    public int hashCode() {
        return this.exceptionName.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if(this == other){
            return true;
        }
        if(!(other instanceof RollbackRule)){
            return false;
        }
        RollbackRule rule = (RollbackRule) other;
        return this.exceptionName.equals(rule.exceptionName);
    }

    @Override
    public String toString() {
        return "RollbackRule with pattern [" + this.exceptionName + "]";
    }
}
