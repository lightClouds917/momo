package com.java4all.momo.entity;

/**
 * @author ITyunqing
 * @date 2019年10月20日 21:28:17
 */
public class TransactionDo {

    private String xid;

    private String resourceGroupId;

    private String resourceId;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
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
}
