package com.java4all.momo.nettydemo;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.Random;

/**
 * netty pool
 * @author IT云清
 * 参考：https://www.jianshu.com/p/7132d84c2461
 */
public class NettyChannelPool {
    private final String host = "localhost";
    private final int port = 8888;

    private Channel[] channels;
    private Object[] locks;
    private static final int MAX_CHANNEL_COUNT = 4;

    // TODO
    public Channel syncGetChannel(){
        int index = new Random().nextInt(MAX_CHANNEL_COUNT);
        Channel channel = channels[index];
        if(null != channel && channel.isActive()){
            return channel;
        }


        return null;
    }

    public Channel connectToServer(){
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host,port)
                .option(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
                .option(ChannelOption.TCP_NODELAY,Boolean.TRUE)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new EchoClientHandler());
                    }
                });

        try {
            ChannelFuture future = bootstrap.connect().sync();
            Channel channel = future.sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
