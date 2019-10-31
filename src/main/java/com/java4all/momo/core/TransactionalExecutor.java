package com.java4all.momo.core;

/**
 * @author IT云清
 */
public interface TransactionalExecutor {

    Object execute() throws Throwable;
}
