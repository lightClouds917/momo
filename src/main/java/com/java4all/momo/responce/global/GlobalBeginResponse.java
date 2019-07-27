package com.java4all.momo.responce.global;

import com.java4all.momo.responce.AbstractTransactionResponse;

/**
 * Global begin response
 * @author IT云清
 */
public class GlobalBeginResponse extends AbstractTransactionResponse {

    private String xid;

    private String extraData;

    private String exceptionCode;

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
