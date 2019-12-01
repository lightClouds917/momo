package com.java4all.momo.core;


import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.constant.StoreMode;

/**
 * @author IT云清
 * @date 2019年10月31日 21:26:25
 */
public class DefaultGlobalTransaction extends GlobalTransaction{
    private static final int DEFAULT_GLOBAL_TX_TIMEOUT = 60000;

    /**global transaction role*/
    private GlobalTransactionRole globalTransactionRole;

    /**global transaction status*/
    private GlobalStatus globalStatus;


    public DefaultGlobalTransaction() {
    }

    public DefaultGlobalTransaction(String xid,
            GlobalTransactionRole globalTransactionRole,
            GlobalStatus globalStatus,
            StoreMode storeMode) {
        this.setXid(xid);
        this.globalTransactionRole = globalTransactionRole;
        this.globalStatus = globalStatus;
        this.setStoreMode(storeMode);
    }
}
