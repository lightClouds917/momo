package com.java4all.momo.nettydemo;

import com.java4all.momo.constant.TransactionType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author IT云清
 */
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer(TransactionType.COMMIT,CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf)
            throws Exception {
        System.out.println("Client received:"+ byteBuf.toString(CharsetUtil.UTF_8));
    }
}