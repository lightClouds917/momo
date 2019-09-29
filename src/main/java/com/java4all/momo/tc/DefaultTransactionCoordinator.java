package com.java4all.momo.tc;

import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.request.global.GlobalCommitRequest;
import com.java4all.momo.request.global.GlobalRollbackRequest;
import com.java4all.momo.responce.global.GlobalBeginResponse;
import com.java4all.momo.responce.global.GlobalCommitResponse;
import com.java4all.momo.responce.global.GlobalRollbackResponse;

/**
 * @author IT云清
 */
public class DefaultTransactionCoordinator implements TransactionCoordinator{

    /**
     * do global begin
     */
    @Override
    public GlobalBeginResponse doGlobalBegin(GlobalBeginRequest request) {
        return null;
    }

    /**
     * do global commit
     */
    @Override
    public GlobalCommitResponse doGlobalCommit(GlobalCommitRequest request) {
        return null;
    }

    /**
     * do global rollback
     */
    @Override
    public GlobalRollbackResponse doGlobalRollback(GlobalRollbackRequest request) {
        return null;
    }
}
