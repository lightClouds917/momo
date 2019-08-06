package com.java4all.momo.tc;

import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.request.global.GlobalCommitRequest;
import com.java4all.momo.request.global.GlobalRollbackRequest;
import com.java4all.momo.responce.global.GlobalBeginResponse;
import com.java4all.momo.responce.global.GlobalCommitResponse;
import com.java4all.momo.responce.global.GlobalRollbackResponse;

/**
 * Transaction coordinator
 * TC:事务协调者
 * 维护全局事务的运行状态，负责协调并驱动全局事务的提交或者回滚。
 * @author IT云清
 */
public interface TransactionCoordinator {

    /**
     * do global begin
     * @param request
     * @return
     */
    GlobalBeginResponse doGlobalBegin(GlobalBeginRequest request);

    /**
     * do global commit
     * @param request
     * @return
     */
    GlobalCommitResponse doGlobalCommit(GlobalCommitRequest request);

    /**
     * do global rollback
     * @param request
     * @return
     */
    GlobalRollbackResponse doGlobalRollback(GlobalRollbackRequest request);

}
