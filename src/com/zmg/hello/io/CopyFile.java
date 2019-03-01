package com.zmg.hello.io;

import java.io.*;

/**
 * 文件、图片、视频什么的，非文本的都只能用字节流来读取
 * 文本文件可以用字符流
 */
/**
 * 抽象基类         节点流（文件流）         缓冲流（处理流的一种，可以提升文件的操作效率）    转换流
 * InputStream      FileInputStream         BufferedInputStream                            InputStreamReader
 * OutputStream     FileOutputStream        BufferedOutputStream (flush())                 OutputStreamWriter
 * Reader           FileReader              BufferedReader （readLine())
 * Wrider           FileWrider              BufferedWrider  (flush)
 */

/**
 * 转换流
 * InputStreamReader(解密)
 * OutputStreamWrider(加密)
 */
public class CopyFile {

    public static void main(String[] args) {
        long from = System.currentTimeMillis();
        String src = "F:\\ztyLeft.jpeg";
        String desc = "F:\\ztyLeft2.jpeg";
        CopyFile cf = new CopyFile();
        cf.copyFileByBufferedStream(src,desc);
        System.out.println(System.currentTimeMillis()-from);
    }


    /**
     * 通关转换流，将字节流转换成字符流，并且加密解密
     * @param src
     * @param desc
     */
    public void copyFileByTransfer(String src,String desc) {
        try {
            //解密
            File srcFile = new File(src);
            FileInputStream fis = null;
            fis = new FileInputStream(srcFile);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            BufferedReader br = new BufferedReader(isr);

            //加密
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desc),"GBK"));

            String line;
            while ((line = br.readLine())!=null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 通过字符缓冲流复制文件
     * @param src
     * @param desc
     */
    public void copyFileByBufferd(String src,String desc) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File(src);
            File descFile = new File(desc);
            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(descFile));
            String line;
            while ((line=br.readLine())!=null) {
                bw.write(line);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 通过缓冲字节流复制文件
     * @param src
     * @param desc
     */
    public void copyFileByBufferedStream(String src,String desc) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(src);
            File descFile = new File(desc);
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(descFile));
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b))!=-1) {
                bos.write(b,0,len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 复制文件通过节点字符流来实现
     * @param src
     * @param desc
     */
    public void copyFileByFileReader(String src,String desc) {
        File srcFile = new File(src);
        File descFile = new File(desc);
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(descFile);
            char[] c = new char[1024];
            int len;
            while ((len=fr.read(c))!=-1) {
                fw.write(c,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过节点字节流byte[]实现文件复制*/
    public void copyFileByByte(String src,String desc) {
        File srcFile = new File(src);
        File descFile = new File(desc);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);
            byte[] b = new byte[1024];//数组长度根据实际文件来设置
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
