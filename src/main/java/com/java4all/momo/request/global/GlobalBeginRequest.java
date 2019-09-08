package com.java4all.momo.request.global;

import com.java4all.momo.request.AbstractTransactionRequest;

/**
 * Global transaction begin request
 * @author IT云清
 */
public class GlobalBeginRequest  extends AbstractTransactionRequest {

    private int timeout = 60000;

    private String transactionName;

    private String xid;

    //handler 方法

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    @Override
    public String toString() {
        return "GlobalBeginRequest{" +
                "timeout=" + timeout +
                ", transactionName='" + transactionName + '\'' +
                ", xid='" + xid + '\'' +
                '}';
    }
}
