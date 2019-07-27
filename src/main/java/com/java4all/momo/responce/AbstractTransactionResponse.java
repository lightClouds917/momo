package com.java4all.momo.responce;

import java.io.Serializable;

/**
 * @author IT云清
 */
public class AbstractTransactionResponse implements Serializable{

    protected static final long serialVersionUID = 1441020418526899889L;

    private String resultCode;

    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
