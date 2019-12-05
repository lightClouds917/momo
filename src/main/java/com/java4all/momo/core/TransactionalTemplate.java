package com.java4all.momo.core;

import com.java4all.momo.context.GlobalTransactionContext;
import com.java4all.momo.entity.TransactionInfo;
import com.java4all.momo.exception.NeverHappenExcetion;
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

        //2.begin
        this.beginTransaction(tx,transactionInfo);
        
        try{
            business.execute();
        }catch (Exception ex){
            //TODO
            throw ex;
        }
        
        //4.commit 
        this.commitTransaction(tx);
        
        

        //TODO
        return null;
    }

    private void commitTransaction(GlobalTransaction tx) {
        tx.commit();
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
