package com.java4all.momo.store;

import com.java4all.momo.entity.BranchTransactionDo;
import com.java4all.momo.entity.GlobalTransactionDo;
import java.util.List;

/**
 * Mysql log store
 * @author ITyunqing
 * @date 2019年10月18日 10:03:45
 */
public class MysqlLogStoreDao implements LogStore{

    @Override
    public GlobalTransactionDo queryGlobalTransactionDo(String xid) {
        return null;
    }

    @Override
    public List<GlobalTransactionDo> queryGlobalTransactionDo(int[] status) {
        return null;
    }

    @Override
    public boolean insertGlobalTransactionDo(GlobalTransactionDo globalTransactionDo) {
        return false;
    }

    @Override
    public boolean deleteGlobalTransactionDo(GlobalTransactionDo globalTransactionDo) {
        return false;
    }

    @Override
    public boolean updateGlobalTransactionDo(GlobalTransactionDo globalTransactionDo) {
        return false;
    }

    @Override
    public BranchTransactionDo queryBranchTransactionDo(String xid) {
        return null;
    }

    @Override
    public List<BranchTransactionDo> queryBranchTransactionDo(int[] status) {
        return null;
    }

    @Override
    public boolean insertBranchTransactionDo(BranchTransactionDo branchTransactionDo) {
        return false;
    }

    @Override
    public boolean deleteBranchTransactionDo(BranchTransactionDo branchTransactionDo) {
        return false;
    }

    @Override
    public boolean updateBranchTransactionDo(BranchTransactionDo branchTransactionDo) {
        return false;
    }
}
