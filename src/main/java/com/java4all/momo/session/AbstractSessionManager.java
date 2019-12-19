package com.java4all.momo.session;

import com.java4all.momo.constant.BranchStatus;
import com.java4all.momo.constant.GlobalStatus;
import java.util.Collection;
import java.util.List;

/**
 * AbstractSessionManager
 * @author ITyunqing
 */
public class AbstractSessionManager implements SessionManager, SessionLifecycleListener{

    @Override
    public void destroy() {

    }

    @Override
    public void onBegin(GlobalSession globalSession) {

    }

    @Override
    public void onStatusChange(GlobalSession globalSession, GlobalStatus status) {

    }

    @Override
    public void addGlobalSession(GlobalSession globalSession) {

    }

    @Override
    public void onAddBranch(GlobalSession globalSession, BranchSession branchSession) {

    }

    @Override
    public GlobalSession findGlobalSession(String xid) {
        return null;
    }

    @Override
    public void onremoveBranch(GlobalSession globalSession, BranchSession branchSession) {

    }

    @Override
    public GlobalSession findGlobalSession(String xid, boolean withBranchSessions) {
        return null;
    }

    @Override
    public void onBranchStatusChange(GlobalSession globalSession, BranchSession branchSession,
            BranchStatus branchStatus) {

    }

    @Override
    public void updateGlobalSessionStatus(GlobalSession globalSession, GlobalStatus globalStatus) {

    }

    @Override
    public void removeGlobalSession(GlobalSession globalSession) {

    }

    @Override
    public void onEnd(GlobalSession globalSession) {

    }

    @Override
    public void onClose(GlobalSession globalSession) {

    }

    @Override
    public void addBranchSession(BranchStatus branchStatus) {

    }

    @Override
    public void updateBranchSessionStatus(BranchSession branchSession, BranchStatus branchStatus) {

    }

    @Override
    public void removeBranchSession(GlobalSession globalSession, BranchSession branchSession) {

    }

    @Override
    public Collection<GlobalSession> allGlobalSessions() {
        return null;
    }

    @Override
    public List<GlobalSession> findGlobalSessions(SessionCondition condition) {
        return null;
    }
}
