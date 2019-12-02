package com.java4all.momo.core;


import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.constant.StoreMode;

/**
 * @author IT云清
 * @date 2019年10月31日 21:26:25
 */
public class DefaultGlobalTransaction{
    private static final int DEFAULT_GLOBAL_TX_TIMEOUT = 60000;

    private String xid;

    private String txServiceGroup;

    private String groupId;

    private StoreMode storeMode = StoreMode.MEMORY;

    /**global transaction role*/
    private GlobalTransactionRole globalTransactionRole;

    /**global transaction status*/
    private GlobalStatus globalStatus;


    public DefaultGlobalTransaction() {
    }

    public DefaultGlobalTransaction(String xid, String txServiceGroup, String groupId,
            StoreMode storeMode, GlobalTransactionRole globalTransactionRole,
            GlobalStatus globalStatus) {
        this.xid = xid;
        this.txServiceGroup = txServiceGroup;
        this.groupId = groupId;
        this.storeMode = storeMode;
        this.globalTransactionRole = globalTransactionRole;
        this.globalStatus = globalStatus;
    }
}
