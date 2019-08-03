package com.java4all.momo.nettydemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * echo client
 * @author IT云清
 */
public class EchoClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoClient.class);

    private final String host;
    
    private final int port;

    public void start()throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host,port)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new EchoClientHandler());
                    }
                });
        try {
            LOGGER.info("EchoClient started on {}:{}",host,port);
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
    
    public static void main(String[]args)throws Exception{
        new EchoClient("localhost",8888).start();
    }

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
