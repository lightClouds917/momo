package com.java4all.momo.core;

/**
 * @author wangzhongxiang
 * @date 2019年07月16日 10:53:48
 */
public class GlobalTransaction {

    /**
     * 全局事务id
     */
    public String xid = "";

    /**
     * 全局事务状态
     */
    public int statu = 0;





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
