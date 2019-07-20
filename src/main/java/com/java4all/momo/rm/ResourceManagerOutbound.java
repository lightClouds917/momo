package com.java4all.momo.rm;

import com.java4all.momo.constant.BranchStatus;

/**
 * Resource manager(RM)
 * send outbound request to transaction coordinate(TC)
 *
 * @author IT云清
 */
public interface ResourceManagerOutbound {


    /**
     * branch register
     *
     * @param xid               transaction id
     * @param clientId          client id
     * @param resourceId        resource id
     * @param applicationData   application data bind with this branch
     * @return
     */
    Long branchRegister(String xid,String clientId,String resourceId,String applicationData);

    /**
     * branch report
     *
     * @param xid               transaction id
     * @param branchId          branch id
     * @param status            branch status
     * @param applicationData   application data bind with this branch
     */
    void branchReport(String xid,long branchId,BranchStatus status,String applicationData);

}
