package com.java4all.momo.tm;

/**
 * Transaction hook
 * @author ITyunqing
 */
public interface TransactionHook {

    void beforeBegin();

    void afterBegin();

    void beforeCommit();

    void afterCommit();

    void beforeRollback();

    void afterRollback();

    void afterCompletion();

}
