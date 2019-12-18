package com.java4all.momo.netty;

import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ITyunqing
 */
public class ShutdownHook extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShutdownHook.class);
    private static final ShutdownHook SHUTDOWN_HOOK = new ShutdownHook("ShutdownHook");
    private Set<Disposable> disposables = new TreeSet<>();
    /**
     * default 10,lower value have higher priority
     */
    private static final int DEFAULT_PRIORITY = 10;

    static {
        Runtime.getRuntime().addShutdownHook(SHUTDOWN_HOOK);
    }

    public ShutdownHook(String shutdownHook) {
        super(shutdownHook);
    }

    public static ShutdownHook getInstance(){
        return SHUTDOWN_HOOK;
    }

    public static void removeRuntimeShutdownHook(){
        Runtime.getRuntime().removeShutdownHook(SHUTDOWN_HOOK);
    }

    public void addDisposable(Disposable disposable){
        this.addDisposable(disposable,DEFAULT_PRIORITY);
    }

    public void addDisposable(Disposable disposable,int priority){
        disposables.add(new DisposablePriorityWrapper(disposable,priority));
    }


    private static class DisposablePriorityWrapper implements Comparable<DisposablePriorityWrapper>,Disposable{

        private Disposable disposable;
        private int priority;

        public DisposablePriorityWrapper(Disposable disposable, int priority) {
            this.disposable = disposable;
            this.priority = priority;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public void destroy() {
            disposable.destroy();
        }

        @Override
        public int compareTo(DisposablePriorityWrapper o) {
            //TODO
            return priority - o.priority;
        }
    }
}
