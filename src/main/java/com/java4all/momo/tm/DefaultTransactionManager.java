package com.java4all.momo.tm;

import com.java4all.momo.constant.GlobalStatus;
import com.java4all.momo.exception.RemoteCallExcaption;
import com.java4all.momo.netty.TmRpcClient;
import com.java4all.momo.request.AbstractTransactionRequest;
import com.java4all.momo.request.global.GlobalBeginRequest;
import com.java4all.momo.request.global.GlobalCommitRequest;
import com.java4all.momo.request.global.GlobalRollbackRequest;
import com.java4all.momo.responce.AbstractTransactionResponse;
import com.java4all.momo.responce.global.GlobalBeginResponse;
import com.java4all.momo.responce.global.GlobalCommitResponse;
import com.java4all.momo.responce.global.GlobalRollbackResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Default transaction manager
 * @author IT云清
 */
public class DefaultTransactionManager extends ChannelInboundHandlerAdapter implements TransactionManager  {

    /**
     * begin a new global transaction
     *
     * @param applicationId the application id who
     * @param transactionServiceGroupId the transation service group id
     * @param name global transaction name
     * @return xid of global transaction
     */
    @Override
    public String begin(String applicationId, String transactionServiceGroupId, String name,
            int timeout) {
        GlobalBeginRequest request = new GlobalBeginRequest();
        request.setTransactionName(name);
        request.setTimeout(timeout);
        GlobalBeginResponse response = (GlobalBeginResponse) TmRpcClient.syncCall(request);
        String xid = response.getXid();
        return xid;
    }

    /**
     * commit a global transaction
     *
     * @param xid xid of global transaction
     * @return the global transaction status after commit
     */
    @Override
    public GlobalStatus commit(String xid) {
        GlobalCommitRequest request = new GlobalCommitRequest();
        request.setXid(xid);
        GlobalCommitResponse response = (GlobalCommitResponse) TmRpcClient
                .syncCall(request);

        return null;
    }

    /**
     * rollback a global transaction
     *
     * @param xid xid of global transaction
     * @return the global transaction status after rollback
     */
    @Override
    public GlobalStatus rollback(String xid) {
        GlobalRollbackRequest request = new GlobalRollbackRequest();
        request.setXid(xid);
        GlobalRollbackResponse response = (GlobalRollbackResponse) TmRpcClient
                .syncCall(request);
        return null;
    }

    /**
     * get the global transaction status
     *
     * @param xid xid of global transaction
     * @return the global transaction status
     */
    @Override
    public GlobalStatus getStatus(String xid) {
        return null;
    }

    public AbstractTransactionResponse syncCall(AbstractTransactionRequest request){
        try {
            //远程调用

        }catch (Exception ex){
            throw new RemoteCallExcaption("【momo】 remote call error");
        }
        return null;
    }

    /**
     * prepare for commit
     * @param xid xid of global transaction
     * @return
     */
    public GlobalStatus prepareForCommit(String xid){
        //TODO
        return null;
    }

    /**
     * clean up after commit
     * @param xid
     */
    public void cleanUpAfterCommit(String xid){
        //TODO
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }
}
