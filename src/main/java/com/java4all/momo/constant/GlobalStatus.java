package com.java4all.momo.constant;

/**
 * Global transaction status
 * @author IT云清
 */
public class GlobalStatus {

    private String xid;

    private Integer status;

    public GlobalStatus() {
    }

    public GlobalStatus(String xid, Integer status) {
        this.xid = xid;
        this.status = status;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
