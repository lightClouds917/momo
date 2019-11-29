package com.java4all.momo.context;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class RootContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(RootContext.class);

    public static final String KEY_XID = "TX_XID";
    public static final String KEY_GLOBAL_LOCK_KEY = "TX_LOCK";
    public static ContextCore CONTEXT_HOLDER = ContextCoreLoader.load();

    /**
     * get xid
     * @return
     */
    public static String getXID(){
        return CONTEXT_HOLDER.get(KEY_XID);
    }

    /**
     * bind
     * @param xid
     */
    public static void bind(String xid){
        CONTEXT_HOLDER.put(KEY_XID,xid);
    }

    /**
     * unbind
     * @return
     */
    public static String unbind(){
        String xid = CONTEXT_HOLDER.remove(KEY_XID);
        return xid;
    }

    /**
     * Whether it is within the global transaction
     * @return
     */
    public static boolean isInGlobalTransaction(){
        return null != CONTEXT_HOLDER.get(KEY_XID);
    }

    /**
     * declare local transaction will use global lock check for update/delete/insert/selectForUpdate SQL
     */
    public static void bindGlobalLock(){
        CONTEXT_HOLDER.put(KEY_GLOBAL_LOCK_KEY,KEY_GLOBAL_LOCK_KEY);
    }

    /**
     * unbind globalLock
     */
    public static void unbindGlobalLock(){
        CONTEXT_HOLDER.remove(KEY_GLOBAL_LOCK_KEY);
    }


    /**
     * Check if global lock is required
     * @return
     */
    public static boolean requireGlobalLock(){
        return null != CONTEXT_HOLDER.get(KEY_GLOBAL_LOCK_KEY);
    }


    public static Map<String,String> entries(){
        return CONTEXT_HOLDER.entries();
    }
}
