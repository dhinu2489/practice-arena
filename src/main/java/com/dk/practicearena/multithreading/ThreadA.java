package com.dk.practicearena.multithreading;

import java.io.*;

public class ThreadA extends ThreadConfig implements Runnable {

    private static int cursor=0;


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        splitFiles();
    }

    private void splitFiles(){

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("input/sbr.log")))){
            System.out.println("File is being read by ..."+Thread.currentThread().getName());
            reader.mark(ThreadConfig.FILE_READ_INDEX);
            String line;
            synchronized (this) {
                while ((line = reader.readLine()) != null) {
                    System.out.println("line = " + line);
                    cursor++;
                    ThreadContext.setCurrentDataKey(cursor);
                    ThreadContext.setDataChunks(cursor, line.getBytes());
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
