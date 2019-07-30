package com.java4all.momo.nettydemo;

import com.alibaba.fastjson.JSONPObject;
import com.java4all.momo.request.branch.BranchRegistRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author IT云清
 */
public class TransactionManagerClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //向tc发送消息
        BranchRegistRequest request = new BranchRegistRequest();
        ctx.writeAndFlush("");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
