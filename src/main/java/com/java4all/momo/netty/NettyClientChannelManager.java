package com.java4all.momo.netty;

import io.netty.channel.Channel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author IT云清
 */
public class NettyClientChannelManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientChannelManager.class);

    private final ConcurrentMap<String,Channel> channels = new ConcurrentHashMap<>();

    /**
     * Acquire netty2 client channel connect to remote server
     * @param serverAddress server address
     * @return
     */
    public Channel acquireChannel(String serverAddress){
        Channel channelToServer = channels.get(serverAddress);
        if(null != channelToServer){


        }
        return null;
    }

    public Channel getExistAliveChannel(Channel rmChannel,String serverAddress){
        if(rmChannel.isActive()){
            return rmChannel;
        }else {
            int i = 0;
            for (;i < NettyClientConfig.getMaxCheckAliveRetry();i ++){
                try {
                    Thread.sleep(NettyClientConfig.getCheckAliveInternal());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rmChannel = channels.get(serverAddress);
                //TODO seata?? NettyClientChannelManager
                if(null != rmChannel || rmChannel.isActive()){
                    return rmChannel;
                }
                if(i == NettyClientConfig.getMaxCheckAliveRetry()){
                    LOGGER.warn("channel"+rmChannel+"is not active after too long wait,clost it!");

                }
            }
        }
        return null;
    }
}
