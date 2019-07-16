package com.java4all.momo.core;

/**
 * @author IT云清
 * @date 2019年07月16日 10:53:48
 */
public class GlobalTransaction {

    /**
     * 事务组
     */
    public String groupId;

    /**
     * 全局事务id
     */
    public String xid;

    /**
     * 全局事务状态
     */
    public int statu;





    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }
}
