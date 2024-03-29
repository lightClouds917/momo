package com.java4all.momo.nettydemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java4all.momo.constant.TransactionType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * echo serverhandler
 * @author IT云清
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(null == msg){
            return;
        }
        ByteBuf in = (ByteBuf) msg;
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(in.toString(CharsetUtil.UTF_8), Map.class);
        String transationType = map.get("command").toString();
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
        String response = "【momo】Global transaction "+transationType+"ed";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
