package com.java4all.momo.entity;

/**
 * @author ITyunqing
 */
public class TransactionInfo {

    private static final int DEFAULT_TIME_OUT = 60000;

    private int timeOut;

    private String name;

    //TODO add rollback rolls

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
