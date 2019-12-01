package com.java4all.momo.core;

import com.java4all.momo.constant.StoreMode;

/**
 * @author IT云清
 */
public class GlobalTransaction {

    private String xid;

    private String txServiceGroup;

    private String groupId;

    private StoreMode storeMode = StoreMode.MEMORY;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getTxServiceGroup() {
        return txServiceGroup;
    }

    public void setTxServiceGroup(String txServiceGroup) {
        this.txServiceGroup = txServiceGroup;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public StoreMode getStoreMode() {
        return storeMode;
    }

    public void setStoreMode(StoreMode storeMode) {
        this.storeMode = storeMode;
    }
}
