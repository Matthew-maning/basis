package com.designpatterns.adapter;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.adapter
 * Version: V1.0
 */

// 通常情况下的adapter 不是adapter模式， 例子如下， 为了重写部分方法而设计

public class NotAdapter {
    public static void main(String[] args) {
        IMethod m1 = new Method1();
        IMethod m2 = new Method2();
        m1.func1();
        m1.func2();
        m2.func1();
        m2.func2();
    }
}

interface IMethod {
    void func1();
    void func2();
    void func3();
    void func4();
    void func5();
}

class Method1 implements IMethod {

    @Override
    public void func1() {
        System.out.println("Method1.func1()");
    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }

    @Override
    public void func4() {

    }

    @Override
    public void func5() {

    }
}

class Method2 implements IMethod {
    @Override
    public void func1() {

    }

    @Override
    public void func2() {
        System.out.println("Method2.func2()");
    }

    @Override
    public void func3() {

    }

    @Override
    public void func4() {

    }

    @Override
    public void func5() {

    }
}
