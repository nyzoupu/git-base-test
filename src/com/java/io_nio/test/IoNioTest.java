package com.java.io_nio.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/** 
 * @author Paulsen·Zou 
 * @Date:2016年9月11日下午10:00:33 
 * @version V1.0
 */
public class IoNioTest {

    /**
     * @throws IOException 
     * @throws FileNotFoundException 
     * main(这里用一句话描述这个方法的作用)</p>
     *
     * @param args    设定文件
     * @return void    返回类型
     * @throws
     */
    public static void main(String[] args) throws IOException {
        
        InputStream inputStream = new FileInputStream("D:/shuliAuthData.json");    
        byte[] head = new byte[3];    
        inputStream.read(head);      
        String code = "";    
     
            code = "gb2312";    
        if (head[0] == -1 && head[1] == -2 )    
            code = "UTF-16";    
        if (head[0] == -2 && head[1] == -1 )    
            code = "Unicode";    
        if(head[0]==-17 && head[1]==-69 && head[2] ==-65)    
            code = "UTF-8";    
            
        System.out.println(code);   
        // TODO Auto-generated method stub
//        long startTime = System.currentTimeMillis();
//        FileInputStream fin = new FileInputStream("D:/trunk.zip");
//        FileChannel fc = fin.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        while (fc.read(byteBuffer) != -1) {
////            byteBuffer.clear();
//            byteBuffer.flip();
//            Charset charset = Charset.forName("utf-8");
////            CharsetDecoder decoder = charset.newDecoder();
//            CharBuffer charBuffer = charset.decode(byteBuffer);
//            System.out.println(charBuffer.toString());
//            byteBuffer.clear();
//        }
//        fc.close();
//        System.out.println("nio:" + (System.currentTimeMillis() - startTime));
        
//        long startTime1 = System.currentTimeMillis();
//        RandomAccessFile raf = new RandomAccessFile("D:/trunk.zip", "rw");
//        FileChannel fcChannel = raf.getChannel();
//        MappedByteBuffer mbb = fcChannel.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
//        while (mbb.hasRemaining()) {
//            System.out.print((char) mbb.get());
//        }
//        //mbb.put(0, (byte) 96); // 修改文件
//        raf.close();
//        System.out.println("mapper:" + (System.currentTimeMillis() - startTime1));
    }

    public static String byteBufferToString(ByteBuffer buffer) {
        CharBuffer charBuffer = null;
        try {
            Charset charset = Charset.forName("GBK");
            CharsetDecoder decoder = charset.newDecoder();
            charBuffer = decoder.decode(buffer);
            buffer.flip();
            return charBuffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
