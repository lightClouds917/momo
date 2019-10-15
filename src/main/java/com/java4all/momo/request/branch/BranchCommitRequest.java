package com.java4all.momo.request.branch;

import com.java4all.momo.constant.BranchStatus;
import com.java4all.momo.request.AbstractTransactionRequest;

/**
 * Branch commit request context
 * @author IT云清
 */
public class BranchCommitRequest  extends AbstractTransactionRequest {

    private String xid;

    private long branchId;

    private String resourceId;

    private BranchStatus status;


    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public BranchStatus getStatus() {
        return status;
    }

    public void setStatus(BranchStatus status) {
        this.status = status;
    }
}
