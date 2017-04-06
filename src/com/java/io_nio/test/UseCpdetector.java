package com.java.io_nio.test;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.ByteOrderMarkDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * 导入如下jar<br>
 * cpdetector_1.0.10.jar,antlr-2.7.4.jar,chardet-1.0.jar
*
 * @author Chinaxiang
 * @date 2015-10-11
*
*/
public class UseCpdetector {

    /**
     * 获取URL的编码
    *
     * @param url
     * @return
    */
    public static String getUrlEncode(URL url) {
        /*
         * detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、
         * JChardetFacade、ASCIIDetector、UnicodeDetector。
         * detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
         * 字符集编码。使用需要用到三个第三方JAR包：antlr.jar、chardet.jar和cpdetector.jar
         * cpDetector是基于统计学原理的，不保证完全正确。
        */
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        /*
         * ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
         * 指示是否显示探测过程的详细信息，为false不显示。
        */
        detector.add(new ParsingDetector(false));
        detector.add(new ByteOrderMarkDetector());
        /*
         * JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
         * 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
         * 再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
        *
         * 用到antlr.jar、chardet.jar
        */
        detector.add(JChardetFacade.getInstance());
        // ASCIIDetector用于ASCII编码测定
        detector.add(ASCIIDetector.getInstance());
        // UnicodeDetector用于Unicode家族编码的测定
        detector.add(UnicodeDetector.getInstance());

        java.nio.charset.Charset charset = null;
        try {
            charset = detector.detectCodepage(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (charset != null) {
            return charset.name();
        }
        return null;
    }

    /**
     * 方法三：比较准确，解决了实际问题
     * @param filePath
     * @return
     */
    public static String getFileEncode(String filePath) {
        String charsetName = null;
        try {
            File file = new File(filePath);
            CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
            detector.add(new ParsingDetector(false));
            detector.add(JChardetFacade.getInstance());
            detector.add(ASCIIDetector.getInstance());
            detector.add(UnicodeDetector.getInstance());
            java.nio.charset.Charset charset = null;
            charset = detector.detectCodepage(file.toURI().toURL());
            if (charset != null) {
                charsetName = charset.name();
            } else {
                charsetName = "UTF-8";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return charsetName;
    }

    public static void main(String[] args) {
        //        URL url = new URL("http://www.baidu.com");
        //        String encode = getUrlEncode(url);
        long startTime = System.currentTimeMillis();
        System.out.println(getFileEncode("D:/dowloadOss.txt"));// UTF-8
        System.out.println("耗时: " + (System.currentTimeMillis() - startTime));
    }

}