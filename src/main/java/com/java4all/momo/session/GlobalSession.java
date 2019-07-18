package com.java4all.momo.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * global transaction context
 * @author IT云清
 * @date 2019年07月18日 16:15:26
 * @see GlobalSession from seata
 */
public class GlobalSession {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalSession.class);

    private String xid;

    private long transactionId;

}
