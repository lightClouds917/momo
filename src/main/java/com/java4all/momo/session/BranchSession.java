package com.java4all.momo.session;

import com.java4all.momo.constant.BranchStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * branch transaction context
 * @author IT云清
 * @date 2019年07月18日 16:20:07
 * @see BranchSession from seata
 */
public class BranchSession {
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchSession.class);

    private String xid;

    private long transactionId;

    private long branchId;

    private String resourceGroupId;

    private String resourceId;

    private BranchStatus branchStatus ;

    private String clientId;

}
