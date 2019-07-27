package com.java4all.momo.request.global;

import com.java4all.momo.request.AbstractTransactionRequest;

/**
 * Global transaction commit request
 * @author IT云清
 */
public class GlobalCommitRequest  extends AbstractTransactionRequest {

    private String xid;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }
}
