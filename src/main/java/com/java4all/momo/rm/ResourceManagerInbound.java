package com.java4all.momo.rm;

import com.java4all.momo.constant.BranchStatus;

/**
 * Resource manager(RM)
 * Controller a branch transaction commit or rollback
 * RM:资源管理器
 * 控制分支事务，负责分支事务注册，状态汇报，并接收事务协调器发出的指令，从而驱动分支事务的提交和回滚。
 * @author IT云清
 */
public interface ResourceManagerInbound {

    /**
     * Commit a branch transaction
     * @param xid               transaction id
     * @param branchId          branch id
     * @param resourceId        resource id
     * @param applicationData       application data bind with this branch
     * @return Status of the branch after committing.
     */
    BranchStatus branchCommit(String xid,long branchId,String resourceId,String applicationData);


    /**
     * Rollback a branch transaction
     * @param xid               transaction id
     * @param branchId          branch id
     * @param resourceId        resource id
     * @param applicationData       application data bind with this branch
     * @return Status of the branch after rollbacking.
     */
    BranchStatus brancdRollback(String xid,long branchId,String resourceId,String applicationData);
}
