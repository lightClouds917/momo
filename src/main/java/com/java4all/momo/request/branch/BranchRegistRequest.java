package com.java4all.momo.request.branch;

/**
 * Branch regist request context
 * @author IT云清
 */
public class BranchRegistRequest {

    private String xid;

    private String resourceId;

    private String applicationData;


    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(String applicationData) {
        this.applicationData = applicationData;
    }

    @Override
    public String toString() {
        return "BranchRegistRequest{" +
                "xid='" + xid + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", applicationData='" + applicationData + '\'' +
                '}';
    }
}
