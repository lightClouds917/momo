package com.java4all.momo.context;

import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.core.DefaultGlobalTransaction;
import com.java4all.momo.core.GlobalTransaction;
import com.java4all.momo.core.GlobalTransactionRole;

/**
 * @author IT云清
 */
public class GlobalTransactionContext {

    public static GlobalTransaction getCurrentOrNew(){
        GlobalTransaction current = getCurrent();
        if(null == current){
            return create();
        }
        return current;
    }

    public static GlobalTransaction create(){
        return new DefaultGlobalTransaction();
    }

    public static GlobalTransaction getCurrent(){
        String xid = RootContext.getXID();
        if(xid == null){
            return null;
        }
        return new DefaultGlobalTransaction(xid, GlobalTransactionRole.Participant,GlobalStatus.Begin);
    }
}
