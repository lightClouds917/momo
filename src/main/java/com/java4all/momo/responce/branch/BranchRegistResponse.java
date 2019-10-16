package com.java4all.momo.responce.branch;

import com.java4all.momo.responce.AbstractTransactionResponse;

/**
 * @author IT云清
 */
public class BranchRegistResponse extends AbstractTransactionResponse{

    private long branchId;

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

}
