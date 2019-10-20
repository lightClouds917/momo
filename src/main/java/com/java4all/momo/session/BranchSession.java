package com.java4all.momo.session;

import com.java4all.momo.constant.BranchStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * branch transaction context
 * @author IT云清
 * @see BranchSession from seata
 */
public class BranchSession {
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchSession.class);

    private String xid;

    private long transactionId;

    private long branchId;

    private String resourceGroupId;

    private String resourceId;

    private BranchStatus branchStatus ;

    private String clientId;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getResourceGroupId() {
        return resourceGroupId;
    }

    public void setResourceGroupId(String resourceGroupId) {
        this.resourceGroupId = resourceGroupId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public BranchStatus getBranchStatus() {
        return branchStatus;
    }

    public void setBranchStatus(BranchStatus branchStatus) {
        this.branchStatus = branchStatus;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
