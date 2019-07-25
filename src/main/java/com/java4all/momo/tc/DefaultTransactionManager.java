package com.java4all.momo.tc;

import com.java4all.momo.constant.GlobalStatus;

/**
 * @author IT云清
 */
public class DefaultTransactionManager implements TransactionManager{

    /**
     * begin a new global transaction
     *
     * @param applicationId the application id who
     * @param transactionServiceGroupId the transation service group id
     * @param name global transaction name
     * @return xid of global transaction
     */
    @Override
    public String begin(String applicationId, String transactionServiceGroupId, String name,
            int timeout) {

        return null;
    }

    /**
     * commit a global transaction
     *
     * @param xid xid of global transaction
     * @return the global transaction status after commit
     */
    @Override
    public GlobalStatus commit(String xid) {
        return null;
    }

    /**
     * rollback a global transaction
     *
     * @param xid xid of global transaction
     * @return the global transaction status after rollback
     */
    @Override
    public GlobalStatus rollback(String xid) {
        return null;
    }

    /**
     * get the global transaction status
     *
     * @param xid xid of global transaction
     * @return the global transaction status
     */
    @Override
    public GlobalStatus getStatus(String xid) {
        return null;
    }
}
