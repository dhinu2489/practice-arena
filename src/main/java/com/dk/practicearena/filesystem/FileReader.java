package com.dk.practicearena.filesystem;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {

    private static final String fileName = "sbr.log";

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder(System.getProperty("java.class.path")).
                append("\\input\\").append(fileName);
        System.out.println("builder.toString() = " + builder.toString());
        readFile(builder.toString());
    }

    public static void readFile(String fileName){
        int data;
        byte[] bytes = new byte[1024*10];
        try(InputStream is = new BufferedInputStream(new FileInputStream(fileName))){
            for(int i=0;(data=is.read())!=-1;i++){
                //data=is.read();
                bytes[i]=(byte)data;
            }
            String dataStr=new String(bytes,"windows-1252");
            System.out.println("Data re-constructed:"+dataStr );
            byte[] test="one".getBytes();
            for(int i=0;i<test.length;i++){
                System.out.println(test[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
