package com.java4all.momo.core;


import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.constant.StoreMode;
import com.java4all.momo.context.RootContext;
import com.java4all.momo.exception.NeverHappenExcetion;
import com.java4all.momo.exception.TransactionException;
import com.java4all.momo.tm.TransactionManager;
import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class DefaultGlobalTransaction implements GlobalTransaction{
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultGlobalTransaction.class);

    private static final int DEFAULT_GLOBAL_TX_TIMEOUT = 60000;
    private static final int COMMIT_RETRY_COUNT = 1;
    private static final int ROLLBACK_RETRY_COUNT = 1;

    private String xid;

    private String txServiceGroup;

    private String groupId;

    private StoreMode storeMode = StoreMode.MEMORY;

    /**global transaction role*/
    private GlobalTransactionRole globalTransactionRole;

    /**global transaction status*/
    private GlobalStatus globalStatus;

    private TransactionManager transactionManager;


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
        //if is participant,the xid can not be null,cause the launcher has create xid
        if(globalTransactionRole == GlobalTransactionRole.Participant){
            check();
            LOGGER.info("Ignor begin(),just participate in the current global transaction {}",xid);
        }
        //if is the launcher,the xid must be null,cause this is the begin()
        if(xid != null){
            throw new IllegalStateException();
        }
        if(RootContext.getXID() != null){
            throw new IllegalStateException();
        }
        String xid = transactionManager.begin(null, null, name, timeout);
        globalStatus = GlobalStatus.Begin;
        //bind the xid to the runtime
        RootContext.bind(xid);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Begin new global transation, xid = {}",xid);
        }
    }

    @Override
    public void commit() throws Exception {
        if(globalTransactionRole == GlobalTransactionRole.Participant){
            if(LOGGER.isInfoEnabled()){
                LOGGER.info("Ignore Commit():just participate in the current global transaction");
            }
            return;
        }
        if(xid == null){
            throw new IllegalStateException();
        }
        int retry = COMMIT_RETRY_COUNT;
        try{
            while (retry>0){
                try{
                    globalStatus = transactionManager.commit(xid);
                    break;
                }catch (Exception ex){
                    retry --;
                    if(retry == 0){
                        throw new Exception("failed to report global commit:"+xid);
                    }
                }
            }
        }finally {
            if(RootContext.getXID() != null){
                if(xid.equals(RootContext.getXID())){
                    RootContext.unbind();
                }
            }
        }
    }

    /**
     * global rollback
     */
    @Override
    public void rollback() throws Exception {
        if(globalTransactionRole.equals(GlobalTransactionRole.Participant)){
            if(LOGGER.isInfoEnabled()){
                LOGGER.info("Ignore rollback():just participate in the current global transaction");
            }
        }
        if(xid == null){
            throw new IllegalArgumentException();
        }
        int retry = ROLLBACK_RETRY_COUNT;

        try {
            while(true){
                if(retry > 0){
                    try {
                        transactionManager.rollback(xid);
                        break;
                    }catch (Exception ex){
                        retry --;
                        if(retry == 0){
                            throw new Exception("failed to report the global rollback "+xid);
                        }
                    }
                }
            }
        }finally {
            if(RootContext.getXID() != null){
                if(xid == RootContext.getXID()){
                    RootContext.unbind();
                }
            }
        }
    }

    private void check(){
        if(xid == null){
            throw new NeverHappenExcetion("xid can not be null");
        }
    }
}
