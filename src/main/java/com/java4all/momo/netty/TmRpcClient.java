package com.java4all.momo.netty;

import com.java4all.momo.request.AbstractTransactionRequest;
import com.java4all.momo.responce.AbstractTransactionResponse;

/**
 * @author IT云清
 */
public class TmRpcClient {

    private static TmRpcClient tmRpcClient;
    private static NettyClientConfig config;
    //add something


    public TmRpcClient(NettyClientConfig config) {
        //TODO
    }

    public static AbstractTransactionResponse syncCall(AbstractTransactionRequest request){
        AbstractTransactionResponse abstractTransactionResponse = null;
        try {
            abstractTransactionResponse = TmRpcClient.getInstance().sendMessage(request);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return abstractTransactionResponse;
    }

    public AbstractTransactionResponse sendMessage(AbstractTransactionRequest request){
        //TODO remote call
        return null;
    }

    public static TmRpcClient getInstance(){
        if(null == tmRpcClient){
            synchronized (TmRpcClient.class){
                if(null == tmRpcClient){
                    new TmRpcClient(config);
                }
            }
        }
        return null;
    }

}
