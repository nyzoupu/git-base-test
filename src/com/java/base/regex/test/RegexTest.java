package com.java.base.regex.test;
import java.util.Arrays;  
import java.util.Collections;  
import java.util.List;  
import java.util.TreeSet;  
  
public class RegexTest {  
  
      
    public static void main(String[] args) {  
        //test();  
        ipSort();  
    }  
    /** 
     * 需求:对邮件地址进行校验 
     */  
    public static void checkMail(){  
        String mail="asdd@sina.com";  
        String regex="\\w{6,12}@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";  //较为精确的匹配,  
        regex="\\w+@\\w+(\\.\\w+)+";  //相对不太精确的匹配  注册后,发送激活邮件  
        	
        System.out.println(mail.matches(regex));  
    }  
      
    /** 
     * 需求: 
     * 将虾类字符串转换成, 我要学编程 
     * 到底用四种功能中的那一个呢,或者哪几个呢? 
     * 思路方式: 
     * 1.如果指向知道该字符串是否对是错,使用匹配. 
     * 2.想要将已有的字符串变成另一个字符串,替换 
     * 3.想要安装指定的方式将字符串变成多个字符串,切割. 获取匹配规则以外的子串 
     * 4.想要拿到符合要求的字符串子串, 获取. 获取符合规则的子串. 
     */  
    public static void test(){  
        String str="我我....我我...我要....要要.....要要...学学学..学学.编程....程程...程";  
          
        /** 
         * 将已有字符串变成一个字符串, 使用 替换功能. 
         * 1.可以先去掉 " ." 
         * 2.在将多个充分度的内容变成单个内容. 
         */  
        str=str.replaceAll("\\.+", "");  
        System.out.println(str);  
          
        str=str.replaceAll("(.)\\1+", "$1");  
        System.out.println(str);  
          
    }  
      
    /** 
     * 192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30 
     * 将IP地址进行地址段顺序的排序. 
     * 还按照字符串自然顺序,只要让他们每一段都是3位即可 
     * 1.按照每一段需要的最少多0进行补齐,那么每一段就会至少保证有3位 
     * 2.将每一段只保留3位,这样,所有的Ip地址都是每一段3位. 
     */  
    public static void ipSort(){  
        String ip="192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30 127.0.0.1";  
        ip=ip.replaceAll("(\\d+)", "00$1");  
        System.out.println(ip);  
        ip=ip.replaceAll("0*(\\d{3})", "$1");  
        System.out.println(ip);  
        String[] arr=ip.split(" +");  
        //方法一  
        //Arrays.sort(arr);  
          
        //方法二  
        TreeSet<String> ts=new TreeSet<String>();  
        for(String s:arr){  
            ts.add(s);  
        }  
        for(String s:ts){  
            System.out.println(s.replaceAll("0*(\\d+)", "$1"));  
            //System.out.println(s.replaceAll("0*([1-9]\\d*)", "$1"));  
        }  
          
        //方法三  
        List<String> list= Arrays.asList(arr);  
        for (String s : list) {  
            System.out.println(s);  
        }  
        Collections.sort(list);  
    }  
      
      
}  