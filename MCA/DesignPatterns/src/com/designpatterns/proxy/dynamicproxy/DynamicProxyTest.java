package com.designpatterns.proxy.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.PrimitiveIterator;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.proxy.staticproxy
 * Version: V1.0
 */

public class DynamicProxyTest {
    public static void main(String[] args) {
        testProxy();
        testEnhancer();
    }

    static void testProxy() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject rs = new RealSubject();
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                new Class[] {Subject.class},
                new SubjectInvocationHandler(rs));
        subject.printName();
    }

    static void testEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class); // 设置父类，设置被代理的类
        enhancer.setCallback(new Interceptor()); // 设置拦截器 相当于InvocationHandler
        Subject subject = (RealSubject)enhancer.create(); // 创建被代理类
        subject.printName();
    }

    static class Interceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            System.out.println(o.getClass().getSuperclass().getName());
            System.out.println("enhancer before");
            Object result = null;
            result = methodProxy.invokeSuper(o, objects);
            System.out.println("enhancer after");
            return result;
        }
    }
}



class SubjectInvocationHandler implements InvocationHandler {
    Subject s;

    public SubjectInvocationHandler(Subject s) {
        this.s = s;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before:");
        Object o = method.invoke(s, args);
        System.out.println("end");
        return 0;
    }
}

interface Subject {
    void printName();
}

class RealSubject implements Subject{
    @Override
    public void printName() {
        System.out.println("print");
    }
}
