package com.java4all.momo.nettydemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4all.momo.constant.TransactionType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
@Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter{
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class);

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
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf info = (ByteBuf) msg;
        String s = info.toString(CharsetUtil.UTF_8);
        LOGGER.info("【momo client】receive msg from server {}",s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
    
}
