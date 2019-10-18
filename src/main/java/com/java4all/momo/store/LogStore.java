package com.java4all.momo.store;

/**
 * log store operate
 * @author wangzhongxiang
 * @date 2019年10月18日 09:47:42
 */
public interface LogStore {

    void insertGlobalTransactionDo();

    void deleteGlobalTransactionDo();

    void updateGlobalTransactionDo();

    void insertBranchTransactionDo();

    void deleteBranchTransactionDo();

    void updateBranchTransactionDo();

}
