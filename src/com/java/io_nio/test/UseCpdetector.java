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
 * ��������jar<br>
 * cpdetector_1.0.10.jar,antlr-2.7.4.jar,chardet-1.0.jar
*
 * @author Chinaxiang
 * @date 2015-10-11
*
*/
public class UseCpdetector {

    /**
     * ��ȡURL�ı���
    *
     * @param url
     * @return
    */
    public static String getUrlEncode(URL url) {
        /*
         * detector��̽����������̽�����񽻸������̽��ʵ�����ʵ����ɡ�
         * cpDetector������һЩ���õ�̽��ʵ���࣬��Щ̽��ʵ�����ʵ������ͨ��add���� �ӽ�������ParsingDetector��
         * JChardetFacade��ASCIIDetector��UnicodeDetector��
         * detector���ա�˭���ȷ��طǿյ�̽���������Ըý��Ϊ׼����ԭ�򷵻�̽�⵽��
         * �ַ������롣ʹ����Ҫ�õ�����������JAR����antlr.jar��chardet.jar��cpdetector.jar
         * cpDetector�ǻ���ͳ��ѧԭ��ģ�����֤��ȫ��ȷ��
        */
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        /*
         * ParsingDetector�����ڼ��HTML��XML���ļ����ַ����ı���,���췽���еĲ�������
         * ָʾ�Ƿ���ʾ̽����̵���ϸ��Ϣ��Ϊfalse����ʾ��
        */
        detector.add(new ParsingDetector(false));
        detector.add(new ByteOrderMarkDetector());
        /*
         * JChardetFacade��װ����Mozilla��֯�ṩ��JChardet����������ɴ�����ļ��ı���
         * �ⶨ�����ԣ�һ���������̽�����Ϳ�����������Ŀ��Ҫ������㻹�����ģ�����
         * �ٶ�Ӽ���̽���������������ASCIIDetector��UnicodeDetector�ȡ�
        *
         * �õ�antlr.jar��chardet.jar
        */
        detector.add(JChardetFacade.getInstance());
        // ASCIIDetector����ASCII����ⶨ
        detector.add(ASCIIDetector.getInstance());
        // UnicodeDetector����Unicode�������Ĳⶨ
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
     * ���������Ƚ�׼ȷ�������ʵ������
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
        System.out.println("��ʱ: " + (System.currentTimeMillis() - startTime));
    }

}