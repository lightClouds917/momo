package com.java4all.momo.session;

import com.java4all.momo.constant.BranchStatus;

/**
 * @author IT云清
 */
public class BranchReportResponse {

    private String xid;

    private long branchId;

    private String resourceId;

    private BranchStatus status;

    private String applicationData;

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

    public String getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(String applicationData) {
        this.applicationData = applicationData;
    }

    @Override
    public String toString() {
        return "BranchReportRequest{" +
                "xid='" + xid + '\'' +
                ", branchId=" + branchId +
                ", resourceId='" + resourceId + '\'' +
                ", status=" + status +
                ", applicationData='" + applicationData + '\'' +
                '}';
    }
}
