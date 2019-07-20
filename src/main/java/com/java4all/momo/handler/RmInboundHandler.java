package com.java4all.momo.handler;

import com.java4all.momo.request.BranchCommitRequest;
import com.java4all.momo.request.BranchRollbackRequest;
import com.java4all.momo.responce.BranchCommitResponse;
import com.java4all.momo.responce.BranchRollbackResponse;

/**
 * The interface RM inbound handler
 * @author IT云清
 */
public interface RmInboundHandler {

    /**
     * Handle branch commit response.
     * @param request the commit request
     * @return the commit response
     */
    BranchCommitResponse handler(BranchCommitRequest request);

    /**
     * Handle branch rollback response.
     * @param request the rollback request
     * @return the rollback response
     */
    BranchRollbackResponse handler(BranchRollbackRequest request);

}
