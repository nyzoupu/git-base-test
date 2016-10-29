package com.java.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class B{
    public int b;
    public B(){}
}

interface IA{}

class A extends B implements IA{
    public A() { }

    public A(String str) { }

    public A(String str1, String str2) { }

    private String str;
    public int age;

    public int func1(String name) {
        System.out.println("hello " + name);
        return 8;
    }

    public void func1(String name1, String name2) {
        System.out.println("hello "+name1+","+name2);
    }
}

public class ReflectDemo {
    
    public static void main(String[] args) throws Exception {
        // �����ַ��������
        Class<?> demoClass = Class.forName("com.java.reflect.demo.A");

        // ��������������
        System.out.println("����"+demoClass.getName()); // com.hicoor.test.reflect.A
        // ������������Ĭ��sun.misc.Launcher$AppClassLoader
        System.out.println("���������"+demoClass.getClassLoader().getClass().getName());

        //����Class�Ĺ����޲ι��췽������һ��ʵ��
        A newAObj = (A)demoClass.newInstance();
        
        // �����������������
        Field[] publicFields = demoClass.getFields(); // ��õ�ǰ��͸����е�public���͵��������ԣ����أ�age
        Field[] declareFields = demoClass.getDeclaredFields(); // ��õ�ǰ�ࣨ���������ࣩ�������������ԣ�����private��public�����أ�str age
        Field specifyField = demoClass.getField("age"); // �������ƻ�ȡָ������
        specifyField.setAccessible(true);
        //�޸�����
        specifyField.set(newAObj, 88);
        
        // �����ķ���
        Method[] publicMethods = demoClass.getMethods(); // ���ǰ��͸�����public���͵����з���
        Method[] declareMethods = demoClass.getDeclaredMethods(); // ��õ�ǰ�ࣨ���������ࣩ���������з���������private��public
        Method specifyMethod = demoClass.getDeclaredMethod("func1",new Class<?>[]{java.lang.String.class});  //���ݷ������ͷ�����������ָ����ȡһ������
        //������ö���ķ���
        specifyMethod.invoke(newAObj, "hans");
        
        //��ù��캯��
        Constructor<?>[] publicConstructors = demoClass.getConstructors();
        Constructor<?>[] declareConstructors = demoClass.getDeclaredConstructors();  //��õ�ǰ������������private��public���췽��
        Constructor<?> constructor = demoClass.getConstructor(new Class<?>[]{java.lang.String.class});  //����ָ�����ͻ�ù��췽��
        A newAobj2 = (A)constructor.newInstance("hello");  //����ָ�����캯������ʵ��
        
        //���ʵ�ֵĽӿ�
        Class<?>[] interfaces = demoClass.getInterfaces();
        
        //��ü̳еĸ���
        Class<?> superclass = demoClass.getSuperclass();
    }

    //������һ����������ϸ����
    private static void getMethodDetail(Method method) {
        String methodModifier = Modifier.toString(method.getModifiers());  //�������η�
        String returnType = method.getReturnType().getName();  //��������ֵ
        Class<?>[] parameterTypes = method.getParameterTypes();  //������������
        System.out.print(methodModifier+" "+returnType+" "+ method.getName()+"(");
        int i=1;
        for (Class<?> parameterType : parameterTypes) {
            System.out.print(parameterType.getName() + " arg"+(i++));
            if(i<=parameterTypes.length){
                System.out.print(",");
            }
        }
        System.out.println(") {}");
    }

}