package com.java4all.momo.exception;

/**
 * @author ITyunqing
 * @date 2019年10月16日 20:07:12
 */
public class GlobalTransactionException extends RuntimeException{


    public GlobalTransactionException() {
        super();
    }

    public GlobalTransactionException(String message) {
        super(message);
    }

    public GlobalTransactionException(String message, Throwable cause) {
        super(message, cause);
    }


    public GlobalTransactionException(Throwable cause) {
        super(cause);
    }


    protected GlobalTransactionException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
