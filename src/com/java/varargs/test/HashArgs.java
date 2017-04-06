package com.java.varargs.test;

import java.util.HashMap;
import java.util.Map;

public class HashArgs {

    public HashArgs() {
    }

    public static void main(String[] args) {
        
        /**
         *  在对10进行求余的时候，余数总是整数中的个位上的数字，而不用管其他位是什么；
         *  在与运算中，我们经常需要使用位操作符&来取某些位上的值，例如使用0xff&0x17ae来获取低8位的值，
         *  
         *  现在我们已经发现有点关联了，如果求余结果值的范围刚好跟是[0,求余的底数（a%b中的b））集合一样，那么低位就是求余的结果。
         *  23%16 == 7
         *  23 (0x17)&amp; 0x0F == 0x07
         * 
         *  所以，当需要对2的次幂进行求余时，可以是使用&运算符来代替，效率会倍儿棒。
         *   当x=2^n(n为自然数)时，
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
