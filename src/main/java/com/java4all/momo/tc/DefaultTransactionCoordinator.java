package com.java4all.momo.tc;

import com.java4all.momo.constant.BranchStatus;
import com.java4all.momo.entity.BranchTransactionDo;
import com.java4all.momo.exception.BranchTransactionException;
import com.java4all.momo.exception.GlobalTransactionException;
import com.java4all.momo.netty.TmRpcClient;
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
import com.java4all.momo.session.BranchSession;
import com.java4all.momo.session.GlobalSession;
import com.java4all.momo.session.SessionHolder;
import com.java4all.momo.store.MysqlLogStoreDao;
import com.java4all.momo.util.UUIDGenerator;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;

/**
 * @author IT云清
 */
public class DefaultTransactionCoordinator implements TransactionCoordinator{


    private static final ThreadLocal local1 = new NamedThreadLocal("branch-");
    private static ConcurrentHashMap<String,BranchSession> branchSessionMap = new ConcurrentHashMap();
    private static ConcurrentHashMap<GlobalSession,BranchSession> sessionMap = new ConcurrentHashMap();


    @Autowired
    private MysqlLogStoreDao mysqlLogStoreDao;

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
        long branchId = UUIDGenerator.generateUUID();

        BranchSession branchSession = new BranchSession();
        branchSession.setXid(xid);
        branchSession.setBranchId(branchId);
        branchSession.setResourceId(request.getResourceId());
        branchSession.setBranchStatus(BranchStatus.Registered);

        boolean exist = this.assertGlobalSessionNotNull(xid);
        if (!exist) {
            throw new GlobalTransactionException("has no global transaction,branch regist failed");
        }
        BranchRegistResponse branchRegistResponse;
        BranchTransactionDo branchTransactionDo = new BranchTransactionDo();
        try {
            branchRegistResponse = (BranchRegistResponse) TmRpcClient.syncCall(request);
            branchSessionMap.put(xid,branchSession);
            branchTransactionDo.setXid(xid);
            branchTransactionDo.setBranchId(branchId);
            branchTransactionDo.setBranchStatus(BranchStatus.Registered);
            branchTransactionDo.setResourceId(request.getResourceId());
            mysqlLogStoreDao.insertBranchTransactionDo(branchTransactionDo);
            return branchRegistResponse;
        }catch (Exception ex){
            throw new BranchTransactionException("branch regist failed");
        }
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
        String xid = request.getXid();
        long branchId = request.getBranchId();
        //TODO 向分支事务发送提交请求

        return null;
    }

    /**
     * do branch rollback
     */
    @Override
    public BranchRollbackResponse doBranchRollback(BranchRollbackRequest request) {
        return null;
    }


    private boolean assertGlobalSessionNotNull(String xid){
        GlobalSession globalSession = SessionHolder.findGlobalSession(xid);
        return null == globalSession ? false : true;
    }
}
