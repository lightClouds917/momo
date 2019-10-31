package com.java4all.momo.context;

/**
 * @author IT云清
 */
public class ContextCoreLoader {

    private static class ContextCoreHolder{
        private static ContextCore instance;
        static{
            if(instance == null){
                instance = new ThreadLocalContextCore();
            }
        }
    }

    public static ContextCore load(){
        return ContextCoreHolder.instance;
    }
}
