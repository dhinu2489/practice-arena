package com.dk.practicearena.multithreading;

import java.io.*;

public class ThreadB extends ThreadConfig implements Runnable {

    final StringBuilder builder = new StringBuilder(System.getProperty("java.class.path")).append("/output/out.log");
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
    @Override
    public void run() {

    }

    public void writeFile(){


       try(OutputStream writer = new BufferedOutputStream(new FileOutputStream(builder.toString()))){
            //writer.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
