package com.java.dyn.proxmy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Animal {
    public void makeSound(String name);
}

class Dog implements Animal {
    @Override
    public void makeSound(String name) {
        System.out.println("Hi," + name + ",wang,wang~~");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound(String name) {
        System.out.println("Hi," + name + ",miao,miao~~");
    }
}

/**
 * @author Hans ͨ�ö�̬�����࣬�����ö��󷽷�ǰ�������������һ������ɶ��ô������
 */
class AnimalProxy implements InvocationHandler {
    // Ҫ����Ķ���
    private Object target;

    /**
     * ��ί�ж��󲢷���һ��������
     * 
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        // ȡ�ô������
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        System.out.println("��������ǰ����..");
        // ִ�б����÷�������
        result = method.invoke(target, args);
        System.out.println("�������ú����..");
        return result;
    }

}

public class DynamicProxyJDKDemo {
    public static void main(String[] args) {
        AnimalProxy proxy = new AnimalProxy();
        Animal dogProxy = (Animal) proxy.getInstance(new Dog());
        dogProxy.makeSound("Tom");
    }
}