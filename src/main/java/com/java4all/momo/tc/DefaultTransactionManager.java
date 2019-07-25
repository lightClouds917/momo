package com.java4all.momo.tc;

import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.request.global.GlobalCommitRequest;

/**
 * Default transaction manager
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
        GlobalBeginRequest request = new GlobalBeginRequest();
        request.setTransactionName(name);
        request.setTimeout(timeout);
        //TODO 远程调用后拿到xin
        String xid = "远程调用";
        return xid;
    }

    /**
     * commit a global transaction
     *
     * @param xid xid of global transaction
     * @return the global transaction status after commit
     */
    @Override
    public GlobalStatus commit(String xid) {
        GlobalCommitRequest request = new GlobalCommitRequest();
        request.setXid(xid);
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
