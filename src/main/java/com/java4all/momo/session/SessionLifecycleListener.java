package com.java4all.momo.session;

import com.java4all.momo.constant.BranchStatus;
import com.java4all.momo.constant.GlobalStatus;

/**
 * Session lifecycle listener
 * @author ITyunqing
 */
public interface SessionLifecycleListener {

    void onBegin(GlobalSession globalSession);

    void onStatusChange(GlobalSession globalSession,GlobalStatus status);

    void onAddBranch(GlobalSession globalSession,BranchSession branchSession);

    void onremoveBranch(GlobalSession globalSession,BranchSession branchSession);

    void onBranchStatusChange(GlobalSession globalSession,BranchSession branchSession,BranchStatus branchStatus);

    void onEnd(GlobalSession globalSession);

    void onClose(GlobalSession globalSession);

}
