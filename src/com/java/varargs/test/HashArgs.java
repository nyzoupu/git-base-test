package com.java.varargs.test;

import java.util.HashMap;
import java.util.Map;

public class HashArgs {

    public HashArgs() {
    }

    public static void main(String[] args) {
        
        /**
         *  �ڶ�10���������ʱ���������������еĸ�λ�ϵ����֣������ù�����λ��ʲô��
         *  ���������У����Ǿ�����Ҫʹ��λ������&��ȡĳЩλ�ϵ�ֵ������ʹ��0xff&0x17ae����ȡ��8λ��ֵ��
         *  
         *  ���������Ѿ������е�����ˣ����������ֵ�ķ�Χ�պø���[0,����ĵ�����a%b�е�b��������һ������ô��λ��������Ľ����
         *  23%16 == 7
         *  23 (0x17)&amp; 0x0F == 0x07
         * 
         *  ���ԣ�����Ҫ��2�Ĵ��ݽ�������ʱ��������ʹ��&����������棬Ч�ʻᱶ������
         *   ��x=2^n(nΪ��Ȼ��)ʱ��
         *   a % x = a &amp; (x  - 1 )
         */
        int a = 324;
        int lenght = 16;
        System.out.println(a % lenght);
        System.out.println(a & (lenght - 1));
        
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("key1", "value1");

    }
}
