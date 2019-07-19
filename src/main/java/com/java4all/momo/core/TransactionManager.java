package com.java4all.momo.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.Map;

/**
 * TM 事务管理者
 * @author IT云清
 * @date 2019年07月17日 20:26:47
 */
public class TransactionManager extends ChannelInboundHandlerAdapter{


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Map map = (Map) msg;
    }
}
