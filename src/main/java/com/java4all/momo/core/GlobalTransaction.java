package com.java4all.momo.core;

/**
 * @author ITyunqing
 */
public interface GlobalTransaction {

    void begin(int timeout);
    void begin(int timeout,String name);
}
