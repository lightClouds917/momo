package com.java4all.momo.tm.hook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * TransactionHook manager
 * @author ITyunqing
 */
public class TransactionHookManager {

    private static final ThreadLocal<List<TransactionHook>> LOCAL_HOOKS = new ThreadLocal<>();

    /**
     * get current hooks
     * @return
     */
    public static List<TransactionHook> getHooks(){
        List<TransactionHook> hooks = LOCAL_HOOKS.get();
        if(CollectionUtils.isEmpty(hooks)){
            return new ArrayList<>();
        }
        return Collections.unmodifiableList(hooks);
    }

    /**
     * register hook
     * @param hook
     */
    public static void registerHook(TransactionHook hook){
        if(hook == null){
            throw new NullPointerException("hook can not be null");
        }
        List<TransactionHook> hooks = LOCAL_HOOKS.get();
        if(CollectionUtils.isEmpty(hooks)){
            LOCAL_HOOKS.set(new ArrayList<>());
        }
        LOCAL_HOOKS.get().add(hook);
    }

    /**
     * clear all hooks
     */
    public static void clear(){
        LOCAL_HOOKS.remove();
    }
}
