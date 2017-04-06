package com.java.io_nio.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/** 
 * @author Paulsen��Zou 
 * @Date:2016��9��11������10:00:33 
 * @version V1.0
 */
public class IoNioTest {

    /**
     * @throws IOException 
     * @throws FileNotFoundException 
     * main(������һ�仰�����������������)</p>
     *
     * @param args    �趨�ļ�
     * @return void    ��������
     * @throws
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        long startTime = System.currentTimeMillis();
        FileInputStream fin = new FileInputStream("D:/trunk.zip");
        FileChannel fc = fin.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fc.read(byteBuffer) != -1) {
//            byteBuffer.clear();
            byteBuffer.flip();
            Charset charset = Charset.forName("utf-8");
//            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = charset.decode(byteBuffer);
            System.out.println(charBuffer.toString());
            byteBuffer.clear();
        }
        fc.close();
        System.out.println("nio:" + (System.currentTimeMillis() - startTime));
        
//        long startTime1 = System.currentTimeMillis();
//        RandomAccessFile raf = new RandomAccessFile("D:/trunk.zip", "rw");
//        FileChannel fcChannel = raf.getChannel();
//        MappedByteBuffer mbb = fcChannel.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
//        while (mbb.hasRemaining()) {
//            System.out.print((char) mbb.get());
//        }
//        //mbb.put(0, (byte) 96); // �޸��ļ�
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
