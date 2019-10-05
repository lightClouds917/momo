package com.java4all.momo.tc;

import com.java4all.momo.request.branch.BranchCommitRequest;
import com.java4all.momo.request.branch.BranchRegistRequest;
import com.java4all.momo.request.branch.BranchRollbackRequest;
import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.request.global.GlobalCommitRequest;
import com.java4all.momo.request.global.GlobalRollbackRequest;
import com.java4all.momo.responce.branch.BranchCommitResponse;
import com.java4all.momo.responce.branch.BranchRegistResponse;
import com.java4all.momo.responce.branch.BranchRollbackResponse;
import com.java4all.momo.responce.global.GlobalBeginResponse;
import com.java4all.momo.responce.global.GlobalCommitResponse;
import com.java4all.momo.responce.global.GlobalRollbackResponse;
import com.java4all.momo.session.BranchReportRequest;
import com.java4all.momo.session.BranchReportResponse;
import org.springframework.core.NamedThreadLocal;

/**
 * @author IT云清
 */
public class DefaultTransactionCoordinator implements TransactionCoordinator{


    private static final ThreadLocal local1 = new NamedThreadLocal("branch-");

    //TODO we need return abstract object ,wait abstract
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

    /**
     * do branch regist
     */
    @Override
    public BranchRegistResponse doBranchRegist(BranchRegistRequest request) {
        String xid = request.getXid();
        String resourceId = request.getResourceId();

        BranchRegistResponse registResponse = new BranchRegistResponse();


        return registResponse;
    }

    /**
     * do branch report
     */
    @Override
    public BranchReportResponse doBranchReport(BranchReportRequest request) {
        String xid = request.getXid();
        String resourceId = request.getResourceId();

        BranchReportResponse reportResponse = new BranchReportResponse();
        reportResponse.setXid(xid);
        reportResponse.setResourceId(resourceId);
        return reportResponse;
    }

    /**
     * do branch commit
     */
    @Override
    public BranchCommitResponse doBranchCommit(BranchCommitRequest request) {
        return null;
    }

    /**
     * do branch rollback
     */
    @Override
    public BranchRollbackResponse doBranchRollback(BranchRollbackRequest request) {
        return null;
    }
}
