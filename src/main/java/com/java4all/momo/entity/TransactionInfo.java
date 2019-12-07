package com.java4all.momo.entity;

import com.java4all.momo.exception.NoRollbackRule;
import com.java4all.momo.exception.RollbackRule;
import java.util.Set;

/**
 * @author ITyunqing
 */
public class TransactionInfo {

    private static final int DEFAULT_TIME_OUT = 60000;

    private int timeOut;

    private String name;

    private Set<RollbackRule> rollbackRules;

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RollbackRule> getRollbackRules() {
        return rollbackRules;
    }


    public void setRollbackRules(Set<RollbackRule> rollbackRules) {
        this.rollbackRules = rollbackRules;
    }

    public boolean rollbackOn(Throwable ex){
        RollbackRule winner = null;
        int deepest = Integer.MAX_VALUE;
        if(this.rollbackRules != null){
            for(RollbackRule rule:rollbackRules){
                //todo
            }
        }
        return true;
    }
}
