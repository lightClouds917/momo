package com.java4all.momo.core;


import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.constant.StoreMode;
import com.java4all.momo.exception.NeverHappenExcetion;

/**
 * @author IT云清
 * @date 2019年10月31日 21:26:25
 */
public class DefaultGlobalTransaction implements GlobalTransaction{
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

    public DefaultGlobalTransaction(String xid, GlobalTransactionRole globalTransactionRole,
            GlobalStatus globalStatus,StoreMode storeMode) {
        this.xid = xid;
        this.globalTransactionRole = globalTransactionRole;
        this.globalStatus = globalStatus;
        this.storeMode = storeMode;
    }

    @Override
    public void begin(int timeout) {

    }

    @Override
    public void begin(int timeout, String name) {
        if(globalTransactionRole == GlobalTransactionRole.Participant){

        }
    }

    private void check(){
        if(xid == null){
            throw new NeverHappenExcetion("xid can not be null");
        }
    }
}
