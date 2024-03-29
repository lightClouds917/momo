package com.java4all.momo.request.global;

import com.java4all.momo.request.AbstractTransactionRequest;

/**
 * Global transaction rollback request context
 * @author IT云清
 */
public class GlobalRollbackRequest extends AbstractTransactionRequest{

    private String xid;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }
}
