package com.java4all.momo.rm;

import com.java4all.momo.constant.BranchStatus;

/**
 * Resource manager(RM)
 * Controller a branch transaction commit or rollback
 *
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
