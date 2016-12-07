package com.java.base.network.spider.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SpiderTest {
	public static void main(String[] args) {
		spider("http://image.baidu.com/");
	}
	
	private static void spider(String url){  
        try {  
            URL urls=new URL(url); // ָ��Ҫ��ȡ����վ  
            URLConnection urlconnection=urls.openConnection(); // ������python �е�urlopen �������Ϊ����������һ������ȥ��  
            urlconnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"); // ��Щ�������鿴�������Ϣ����ֹ��ȡ��  
            InputStream ins=urlconnection.getInputStream(); // �����ķ�ʽ��������  
            BufferedReader buff = new BufferedReader(new InputStreamReader(ins, "utf-8")); // ���ַ�������  
            StringBuffer sb=new StringBuffer(); // ��������ȡ����  
            String lines="";  
            while((lines=buff.readLine())!=null){  
                sb.append(lines+"\n");  
            }  
            OutputStreamWriter ops=new OutputStreamWriter(new FileOutputStream("d:/qiubai.html",true),"utf-8"); // д�뵽���ص�W���У�����Ϊqiubai.html  
            ops.write(sb.toString());  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }     
          
    }  
}
