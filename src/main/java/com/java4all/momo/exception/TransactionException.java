package com.java4all.momo.exception;

import java.security.PrivilegedActionException;

/**
 * @author ITyunqing
 */
public class TransactionException extends Exception{
    //TODO



    public TransactionException() {
        super();
    }


    public TransactionException(String message) {
        super(message);
    }


    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }


    public TransactionException(Throwable cause) {
        super(cause);
    }
}
