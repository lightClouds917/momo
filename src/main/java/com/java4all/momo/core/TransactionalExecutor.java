package com.java4all.momo.core;

import com.java4all.momo.entity.TransactionInfo;

/**
 * @author IT云清
 */
public interface TransactionalExecutor {

    Object execute() throws Throwable;

    TransactionInfo getTransactionInfo();
}
