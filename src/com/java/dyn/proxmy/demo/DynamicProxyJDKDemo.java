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
 * @author Hans 通用动态代理类，被调用对象方法前后增加特殊操作一样的类可都用此类代理
 */
class AnimalProxy implements InvocationHandler {
    // 要代理的对象
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * 
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        System.out.println("方法调用前操作..");
        // 执行被调用方法主体
        result = method.invoke(target, args);
        System.out.println("方法调用后操作..");
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