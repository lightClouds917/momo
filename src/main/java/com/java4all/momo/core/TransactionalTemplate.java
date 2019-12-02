package com.java4all.momo.core;

import com.java4all.momo.context.GlobalTransactionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class TransactionalTemplate {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionalTemplate.class);

    public Object execute(TransactionalExecutor business)throws Throwable{
        GlobalTransaction tx = GlobalTransactionContext.getCurrentOrNew();



        //TODO
        return null;
    }

}
