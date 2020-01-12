package com.java4all.momo.tc;


import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.request.global.GlobalCommitRequest;
import com.java4all.momo.request.global.GlobalRegistRequest;
import com.java4all.momo.request.global.GlobalReportRequest;
import com.java4all.momo.request.global.GlobalRollbackRequest;
import com.java4all.momo.responce.branch.BranchRegistResponse;
import com.java4all.momo.responce.global.GlobalBeginResponse;
import com.java4all.momo.responce.global.GlobalCommitResponse;
import com.java4all.momo.responce.global.GlobalReportResponse;
import com.java4all.momo.responce.global.GlobalRollbackResponse;
import com.java4all.momo.session.BranchReportRequest;
import com.java4all.momo.session.BranchReportResponse;

/**
 * @author IT云清
 * @date 2020年01月12日 17:17:13
 */
public class AbstractTCInboundHandler implements TCInboundHandler {

    @Override
    public GlobalBeginResponse handle(GlobalBeginRequest request) {
        return null;
    }

    @Override
    public GlobalCommitResponse handler(GlobalCommitRequest request) {
        return null;
    }

    @Override
    public GlobalRollbackResponse handle(GlobalRollbackRequest request) {
        return null;
    }

    @Override
    public GlobalReportResponse handle(GlobalReportRequest request) {
        return null;
    }

    @Override
    public BranchRegistResponse handle(GlobalRegistRequest request) {
        return null;
    }

    @Override
    public BranchReportResponse handle(BranchReportRequest request) {
        return null;
    }
}
