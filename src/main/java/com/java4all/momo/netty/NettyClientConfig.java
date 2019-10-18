package com.java4all.momo.netty;

/**
 * @author ITyunqing
 * @date 2019年08月03日 14:41:57
 */
public class NettyClientConfig extends NettyBaseConfig{

    private static final int MAX_CHECK_ALIVE_RETRY = 300;
    private static final int CHECK_ALIVE_INTERNAL = 10;

    public static int getMaxCheckAliveRetry() {
        return MAX_CHECK_ALIVE_RETRY;
    }

    public static int getCheckAliveInternal() {
        return CHECK_ALIVE_INTERNAL;
    }
}
