package com.java4all.momo.nettydemo;

import com.java4all.momo.constant.TransactionType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A demo about nettydemo
 * @author IT云清
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        String transationType = in.toString(CharsetUtil.UTF_8);
        switch (transationType){
            case TransactionType.COMMIT:
                LOGGER.info("【momo server】执行{}操作",TransactionType.COMMIT);
                break;
            case TransactionType.ROLLBACK:
                LOGGER.info("【momo server】执行{}操作",TransactionType.ROLLBACK);
                break;
            default:
                LOGGER.info("【momo server】执行{}操作",TransactionType.REGIST);
                break;
        }
        ctx.writeAndFlush("【momo】Global transaction "+transationType+"ed");
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
}
