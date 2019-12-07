package com.java4all.momo.exception;

/**
 * @author ITyunqing
 */
public class NoRollbackRule extends RollbackRule{

    public NoRollbackRule(Class<?> clazz) {
        super(clazz);
    }

    public NoRollbackRule(String exceptionName) {
        super(exceptionName);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
