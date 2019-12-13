package com.java4all.momo.core;

import com.java4all.momo.exception.TransactionException;

/**
 * @author ITyunqing
 */
public interface GlobalTransaction {

    /**
     * global begin
     * @param timeout
     */
    void begin(int timeout);

    /**
     * global begin
     * @param timeout
     * @param name
     */
    void begin(int timeout,String name);

    /**
     * global commit
     * @throws Exception
     */
    void commit() throws Exception;

    /**
     * global rollback
     * @throws Exception
     */
    void rollback() throws Exception;
}
