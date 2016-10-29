/*package com.java.dyn.proxmy.demo;

import java.lang.reflect.Method;


class Snake{
    public void makeSound(String name) {
        System.out.println("Hi," + name + ",si,si~~");
    }
}

class AnimalProxyCglib implements MethodInterceptor {
    // 要代理的对象
    private Object target;

     * 创建代理对象
     * 
     * @param target
     * @return
     *//*
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
            MethodProxy proxy) throws Throwable {
        Object result = null;
        System.out.println("方法调用前操作..");
        // 执行被调用方法主体
        result = proxy.invokeSuper(obj, args);
        System.out.println("方法调用后操作..");
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