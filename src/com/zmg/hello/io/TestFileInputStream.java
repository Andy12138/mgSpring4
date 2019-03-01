package com.zmg.hello.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*实例*/
public class TestFileInputStream {
    public static void main(String[] args) {
        File file = new File("E://d.cmd");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] b = new byte[100];
            int len;
            while ((len = fis.read(b)) != -1) {
                System.out.println(new String(b,0,len).toString());
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
