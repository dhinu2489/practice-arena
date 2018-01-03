package com.dk.practicearena.multithreading;

import java.util.HashMap;
import java.util.Map;

public class ThreadContext {

    final static Map<Integer,byte[]> dataChunks = new HashMap<>();
    private static ThreadContext threadContext;
    private static Integer currentDataKey;

    private ThreadContext() {
    }

    public static ThreadContext getInstance(){
        if(threadContext!=null){
            return threadContext;
        }else{
            threadContext=new ThreadContext();
            return threadContext;
        }
    }

    public static Map<Integer, byte[]> getDataChunks() {
        return dataChunks;
    }

    public static void setDataChunks(int key,byte[] value) {
        dataChunks.put(key,value);
    }

    public static Integer getCurrentDataKey() {
        return currentDataKey;
    }

    public static void setCurrentDataKey(Integer currentDataKey) {
        ThreadContext.currentDataKey = currentDataKey;
    }
}
