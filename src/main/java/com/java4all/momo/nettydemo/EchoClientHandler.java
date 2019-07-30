package com.java4all.momo.nettydemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4all.momo.constant.TransactionType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author IT云清
 */
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Map<String,Object> map = new HashMap();
        map.put("time",new Date());
        map.put("command",TransactionType.COMMIT);
        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(map);

        ctx.writeAndFlush(Unpooled.copiedBuffer(data,CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext,ByteBuf byteBuf)
            throws Exception {
        System.out.println("Client received:"+ byteBuf.toString(CharsetUtil.UTF_8));
    }
}
