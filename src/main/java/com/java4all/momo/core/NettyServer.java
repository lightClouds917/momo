package com.java4all.momo.core;

import com.java4all.momo.aspect.GlobalTransactionalAspect;
import com.java4all.momo.constant.TransactionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.CompositeName;
import org.apache.el.lang.ELArithmetic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author IT云清
 * @date 2019年07月16日 19:26:20
 */
public class NettyServer {

    // socket -> netty TODO 待处理

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalTransactionalAspect.class);

    private static Map<String,List<String>> transactionIdMap = new HashMap<>();

    /**
     * 接收数据
     */
    public void channelRead(){
        LOGGER.info("【momo】receive data......");

        //TODO 从事务参与者出获取的信息  如何传递，序列化效率
        Map<String,String> map = new HashMap<>();
        String command = map.get("command").toString();
        String groudId = map.get("groudId").toString();
        String transactionType = map.get("transactionType").toString();
        String transactionId = map.get("transactionId").toString();

        if(TransactionType.CREATE.equals(command)){
            //start global transaction
            transactionIdMap.put(groudId,new ArrayList<>());
        }else if(TransactionType.REGIST.equals(command)){
            //regist branch transaction
            transactionIdMap.get(groudId).add(transactionId);
        }else if(TransactionType.COMMIT.equals(command)){
            //commit transaction TODO   全局事务还是分支事务
            sendMessage(groudId,TransactionType.COMMIT);
        }else if(TransactionType.ROLLBACK.equals(command)){
            //rollback global transaction
            sendMessage(groudId,TransactionType.ROLLBACK);
        }


    }


    /**
     * send message to TC
     * @param groudId
     * @param commit
     */
    private void sendMessage(String groudId, String commit) {
        //TODO 待处理
    }

}
