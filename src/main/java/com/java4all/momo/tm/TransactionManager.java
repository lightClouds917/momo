package com.java4all.momo.tm;

import com.java4all.momo.constant.GlobalStatus;

/**
 * Transaction manager
 * Define a global transaction and control it.
 * TM:事务管理器
 * 负责全局事务的开启，全局事务的提交，全局事务的回滚
 * @author IT云清
 */
public interface TransactionManager {

    /**
     * begin a new global transaction
     * @param applicationId the application id who
     * @param transactionServiceGroupId the transation service group id
     * @param name global transaction name
     * @param timeout
     * @return xid of global transaction
     */
    String begin(String applicationId,String transactionServiceGroupId,String name,int timeout);

    /**
     * commit a global transaction
     * @param xid xid of global transaction
     * @return the global transaction status after commit
     */
    GlobalStatus commit(String xid);

    /**
     * rollback a global transaction
     * @param xid xid of global transaction
     * @return the global transaction status after rollback
     */
    GlobalStatus rollback(String xid);

    /**
     * get the global transaction status
     * @param xid xid of global transaction
     * @return the global transaction status
     */
    GlobalStatus getStatus(String xid);
}
