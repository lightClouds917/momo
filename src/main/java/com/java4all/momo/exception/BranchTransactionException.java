package com.java4all.momo.exception;

/**
 * @author ITyunqing
 * @date 2019年10月16日 20:07:12
 */
public class BranchTransactionException extends RuntimeException{


    public BranchTransactionException() {
        super();
    }

    public BranchTransactionException(String message) {
        super(message);
    }

    public BranchTransactionException(String message, Throwable cause) {
        super(message, cause);
    }


    public BranchTransactionException(Throwable cause) {
        super(cause);
    }


    protected BranchTransactionException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
