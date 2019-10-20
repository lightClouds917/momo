package com.java4all.momo.entity;

import com.java4all.momo.constant.BranchStatus;

/**
 * @author ITyunqing
 * @date 2019年10月18日 09:53:13
 */
public class BranchTransactionDo extends TransactionDo{

    private long transactionId;

    private long branchId;

    private BranchStatus branchStatus ;

    private String clientId;

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
