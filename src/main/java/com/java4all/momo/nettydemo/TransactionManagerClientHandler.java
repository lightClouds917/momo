package com.java4all.momo.nettydemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4all.momo.request.branch.BranchRegistRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import java.util.Map;

/**
 * @author IT云清
 */
public class TransactionManagerClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(in.toString(CharsetUtil.UTF_8), Map.class);
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
