package com.dk.practicearena.multithreading;

public class CustomThreadExecutor {

    public static void main(String[] args) {

        for(int i=0;i<ThreadConfig.FIXED_THREAD_POOL;i++)
         new Thread(new ThreadA()).start();
    }
}
