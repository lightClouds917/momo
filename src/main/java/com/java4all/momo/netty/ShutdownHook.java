package com.java4all.momo.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ITyunqing
 */
public class ShutdownHook extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShutdownHook.class);
    private static final ShutdownHook SHUTDOWN_HOOK = new ShutdownHook("ShutdownHook");

    static {
        Runtime.getRuntime().addShutdownHook(SHUTDOWN_HOOK);
    }

    public ShutdownHook(String shutdownHook) {
        super(shutdownHook);
    }

    public static ShutdownHook getInstance(){
        return SHUTDOWN_HOOK;
    }
}
