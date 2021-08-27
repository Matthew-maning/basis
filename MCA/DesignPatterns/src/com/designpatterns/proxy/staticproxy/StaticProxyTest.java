package com.designpatterns.proxy.staticproxy;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.proxy.staticproxy
 * Version: V1.0
 */

public class StaticProxyTest {
    public static void main(String[] args) {
        ProxySubject proxy = new ProxySubject();
        proxy.printName();
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

class ProxySubject implements Subject {
    private RealSubject rs = new RealSubject();

    @Override
    public void printName() {
        System.out.println("begin print");
        rs.printName();
        System.out.println("end print");
    }
}
