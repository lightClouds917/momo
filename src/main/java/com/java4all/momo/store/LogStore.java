package com.java4all.momo.store;

import com.java4all.momo.entity.BranchTransactionDo;
import com.java4all.momo.entity.GlobalTransactionDo;
import java.util.List;

/**
 * log store operate
 * @author ITyunqing
 * @date 2019年10月18日 09:47:42
 */
public interface LogStore {

    GlobalTransactionDo queryGlobalTransactionDo(String xid);

    List<GlobalTransactionDo> queryGlobalTransactionDo(int[] status);

    boolean insertGlobalTransactionDo(GlobalTransactionDo globalTransactionDo);

    boolean deleteGlobalTransactionDo(GlobalTransactionDo globalTransactionDo);

    boolean updateGlobalTransactionDo(GlobalTransactionDo globalTransactionDo);

    BranchTransactionDo queryBranchTransactionDo(String xid);

    List<BranchTransactionDo> queryBranchTransactionDo(int[] status);

    boolean insertBranchTransactionDo(BranchTransactionDo branchTransactionDo);

    boolean deleteBranchTransactionDo(BranchTransactionDo branchTransactionDo);

    boolean updateBranchTransactionDo(BranchTransactionDo branchTransactionDo);

}
