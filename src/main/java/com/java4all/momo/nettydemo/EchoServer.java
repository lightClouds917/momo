package com.java4all.momo.nettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class EchoServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class);
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start()throws Exception{
        EchoServerHandler echoServerHandler = new EchoServerHandler();
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(echoServerHandler);
                    }
                });
        try {
            LOGGER.info("server started on 8888");
            ChannelFuture future = serverBootstrap.bind().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
    
    public static void main(String[]args){
        try {
            new EchoServer(8888).start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
}
