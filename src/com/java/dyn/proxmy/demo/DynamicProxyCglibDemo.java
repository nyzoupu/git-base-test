/*package com.java.dyn.proxmy.demo;

import java.lang.reflect.Method;


class Snake{
    public void makeSound(String name) {
        System.out.println("Hi," + name + ",si,si~~");
    }
}

class AnimalProxyCglib implements MethodInterceptor {
    // Ҫ����Ķ���
    private Object target;

     * �����������
     * 
     * @param target
     * @return
     *//*
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // �ص�����
        enhancer.setCallback(this);
        // �����������
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
            MethodProxy proxy) throws Throwable {
        Object result = null;
        System.out.println("��������ǰ����..");
        // ִ�б����÷�������
        result = proxy.invokeSuper(obj, args);
        System.out.println("�������ú����..");
        return result;
    }

}

public class DynamicProxyCglibDemo {

    public static void main(String[] args) {
        AnimalProxyCglib proxy = new AnimalProxyCglib();
        Snake dogProxy = (Snake) proxy.getInstance(new Snake());
        dogProxy.makeSound("Tom");
    }
    
}*/