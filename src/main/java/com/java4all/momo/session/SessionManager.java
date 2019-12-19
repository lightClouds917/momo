package com.java4all.momo.session;

import com.java4all.momo.constant.BranchStatus;
import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.netty.Disposable;
import java.util.Collection;
import java.util.List;

/**
 * Session Manager
 * @author ITyunqing
 */
public interface SessionManager extends SessionLifecycleListener,Disposable{

    void addGlobalSession(GlobalSession globalSession);

    GlobalSession findGlobalSession(String xid);

    GlobalSession findGlobalSession(String xid,boolean withBranchSessions);

    void updateGlobalSessionStatus(GlobalSession globalSession,GlobalStatus globalStatus);

    void removeGlobalSession(GlobalSession globalSession);

    void addBranchSession(BranchStatus branchStatus);

    void updateBranchSessionStatus(BranchSession branchSession,BranchStatus branchStatus);

    void removeBranchSession(GlobalSession globalSession,BranchSession branchSession);

    Collection<GlobalSession> allGlobalSessions();

    List<GlobalSession> findGlobalSessions(SessionCondition condition);

}
