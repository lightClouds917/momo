package com.java4all.momo.session;

import java.util.List;

/**
 * @author ITyunqing
 */
public interface TransactionStoreManager {

    boolean writeSession(LogOperation logOperation,SessionStorable sessionStorable);

    GlobalSession readSession(String xid);

    GlobalSession readSession(String xid,boolean withBranchSession);

    List<GlobalSession> readSession(SessionCondition sessionCondition);

    void shutdown();

    void getCurrentMaxSessionId();

    enum LogOperation{
        GLOBAL_ADD((byte)1),
        GLOBAL_UPDATE((byte)2),
        GLOBAL_REMOVE((byte)3),
        BRANCH_ADD((byte)4),
        BRANCH_UPDATE((byte)5),
        BRANCH_REMOVE((byte)6);

        private byte code;

        LogOperation(byte code) {
            this.code = code;
        }

        public byte getCode() {
            return code;
        }

        public static LogOperation getLogOperationByCode(byte code){
            for(LogOperation logOperation:values()){
                if(logOperation.getCode() == code){
                    return logOperation;
                }
            }
            throw new IllegalArgumentException("Unknown LogOperation"+code);
        }
    }

}
