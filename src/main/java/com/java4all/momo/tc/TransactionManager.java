package com.java4all.momo.tc;

import com.java4all.momo.constant.GlobalStatus;

/**
 * Transaction manager
 * Define a global transaction and control it.
 * @author IT云清
 */
public interface TransactionManager {

    /**
     * begin a new global transaction
     * @param applicationId the application id who
     * @param transactionServiceGroupId the transation service group id
     * @param name global transaction name
     * @param timeout
     * @return
     */
    String begin(String applicationId,String transactionServiceGroupId,String name,int timeout);

    /**
     *
     * @param xid
     * @return
     */
    GlobalStatus commit(String xid);

    GlobalStatus rollback(String xid);

    GlobalStatus getStatus(String xid);
}
