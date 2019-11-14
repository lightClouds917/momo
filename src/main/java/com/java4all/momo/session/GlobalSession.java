package com.java4all.momo.session;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * global transaction context
 * @author IT云清
 * @see GlobalSession from seata
 */
public class GlobalSession {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalSession.class);

    /**
     * dbUrl
     *  table
     *     pk
     * */
    private static final
    ConcurrentHashMap<String,
            ConcurrentHashMap<String,
                    ConcurrentHashMap<String,
                            ConcurrentHashMap<String,Long>>>> map = new ConcurrentHashMap<>();

    /**global session id*/
    private String xid;

    private String transactionName;

    private String transactionServiceGroup;

    private long timeOut;

    private List<BranchSession> branchSessions = new ArrayList<>();

    public GlobalSession(String xid, String transactionName, String transactionServiceGroup,
            long timeOut) {
        this.xid = xid;
        this.transactionName = transactionName;
        this.transactionServiceGroup = transactionServiceGroup;
        this.timeOut = timeOut;
    }

    public void addBranch(BranchSession branchSession){
        branchSessions.add(branchSession);
    }

    public void removeBranch(BranchSession branchSession){
        branchSessions.remove(branchSession);
    }


    //ceshi

    //TODO 什么时候初始化

    public static void init(){

    }

    public List<BranchSession> getBranchSessionList(String xid){
        return branchSessions;
    }
}
