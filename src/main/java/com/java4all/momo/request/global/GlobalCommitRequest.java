package com.java4all.momo.request.global;

/**
 * Global transaction commit request
 * @author IT云清
 */
public class GlobalCommitRequest {

    private String xid;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }
}
