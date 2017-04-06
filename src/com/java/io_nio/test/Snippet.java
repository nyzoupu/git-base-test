package com.java.io_nio.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Snippet {
    public static void main(String[] args) throws Exception {

        System.out.println(codeString("D:/shuliAuthData.json"));
    }

    /**
     * �ж��ļ��ı����ʽ
     * @param fileName :file
     * @return �ļ������ʽ
     * @throws Exception
     */
    public static String codeString(String fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }
}
