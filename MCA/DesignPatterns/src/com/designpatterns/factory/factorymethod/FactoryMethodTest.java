package com.designpatterns.factory.factorymethod;


/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.factory.simplefactory
 * Version: V1.0
 */

public class FactoryMethodTest {
    public static void main(String[] args) {
        AbstractProduct pA = new ProductAFactory().produceProduct();
        AbstractProduct pB = new ProductBFactory().produceProduct();
        pA.productMethod();
        pB.productMethod();
    }
}

abstract class AbstractProduct {
    abstract void productMethod();
}

class ProductA extends AbstractProduct {
    protected ProductA() {
        System.out.println("new productA");
    }
    @Override
    public void productMethod() {
        System.out.println("This is productA method");
    }
}

class ProductB extends AbstractProduct {

    protected ProductB() {
        System.out.println("new productB");
    }

    @Override
    public void productMethod() {
        System.out.println("This is productB method");
    }
}

interface AbstractFactory {
    AbstractProduct produceProduct();
}

class ProductAFactory implements AbstractFactory {

    @Override
    public AbstractProduct produceProduct() {
        return new ProductA();
    }
}

class ProductBFactory implements AbstractFactory {

    @Override
    public AbstractProduct produceProduct() {
        return new ProductB();
    }
}