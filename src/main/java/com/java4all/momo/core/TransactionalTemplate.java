package com.java4all.momo.core;

import com.java4all.momo.context.GlobalTransactionContext;
import com.java4all.momo.entity.TransactionInfo;
import com.java4all.momo.exception.NeverHappenExcetion;
import com.java4all.momo.exception.TransactionException;
import com.java4all.momo.tm.hook.TransactionHook;
import com.java4all.momo.tm.hook.TransactionHookManager;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class TransactionalTemplate {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionalTemplate.class);

    public Object execute(TransactionalExecutor business)throws Throwable{
        //1.get or create a transaction
        GlobalTransaction tx = GlobalTransactionContext.getCurrentOrNew();

        //get transactionInfo
        TransactionInfo transactionInfo = business.getTransactionInfo();

        if(transactionInfo == null){
            throw new NeverHappenExcetion("transaction does not exit");
        }

        try{
            //2.begin
            this.beginTransaction(tx,transactionInfo);
            Object rs = null;
            try{
                rs = business.execute();
            }catch (Exception ex){
                //3.rollback when the business execute failed
                this.completeTransactionAfterThrow(transactionInfo,tx,ex);
                throw ex;
            }

            //4.commit
            this.commitTransaction(tx);
            return rs;
        }finally {
            this.triggerAfterCompletion();
            this.cleanUp();
        }
    }

    private void cleanUp() {
        TransactionHookManager.clear();
    }

    private void triggerAfterCompletion() {
        for(TransactionHook hook:this.getCurrentHooKs()) {
            hook.afterCompletion();
        }
    }

    private void completeTransactionAfterThrow(TransactionInfo transactionInfo,
            GlobalTransaction tx, Exception ex) throws Exception {
        if(transactionInfo != null && transactionInfo.rollbackOn(ex)){
            try{
                this.rollbackTransaction(tx,ex);
            }catch (TransactionException tex){
//TODO
            }
        }else {
            //not rollback on this exception,so commit
            this.commitTransaction(tx);
        }
    }

    private void rollbackTransaction(GlobalTransaction tx, Exception ex)throws Exception {
        this.triggerBeforeRollback();
        tx.rollback();
        this.triggerAfterRollback();
        //TODO should throw something
    }

    private void triggerAfterRollback() {
        for(TransactionHook hook:this.getCurrentHooKs()){
            hook.afterRollback();
        }
    }

    private void triggerBeforeRollback() {
        for(TransactionHook hook:this.getCurrentHooKs()){
            hook.beforeRollback();
        }
    }

    private void commitTransaction(GlobalTransaction tx) throws Exception {
        this.triggerBeforeCommit();
        tx.commit();
        this.triggerAfterCommit();
    }

    private void triggerBeforeCommit() {
        for(TransactionHook  hook:this.getCurrentHooKs()){
            hook.beforeCommit();
        }
    }

    private void triggerAfterCommit() {
        for(TransactionHook hook:this.getCurrentHooKs()){
            hook.afterCommit();
        }
    }

    private void beginTransaction(GlobalTransaction tx, TransactionInfo transactionInfo) {
        this.triggerBeforeBegin();
        tx.begin(transactionInfo.getTimeOut(),transactionInfo.getName());
        this.triggerAfterBegin();

    }

    private void triggerBeforeBegin(){
        for(TransactionHook hook:this.getCurrentHooKs()){
            hook.beforeBegin();
        }
    }

    private void triggerAfterBegin(){
        for(TransactionHook hook:this.getCurrentHooKs()){
            hook.afterBegin();
        }
    }


    private List<TransactionHook> getCurrentHooKs(){
        return TransactionHookManager.getHooks();
    }
}
