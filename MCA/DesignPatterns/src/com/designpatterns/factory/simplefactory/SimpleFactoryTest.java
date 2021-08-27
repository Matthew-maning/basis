package com.designpatterns.factory.simplefactory;

import java.lang.reflect.Method;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.factory.simplefactory
 * Version: V1.0
 */

public class SimpleFactoryTest {

    public static void main(String[] args) {
        AbstractProduct p1 = Factory.produce(Factory.ProductType.PRODUCT_A);
        AbstractProduct p2 = Factory.produce(Factory.ProductType.PRODUCT_B);
        p1.productMethod();
        p2.productMethod();
    }
}

abstract class AbstractProduct {
    public abstract void productMethod();
}

class ProductA extends AbstractProduct {

    @Override
    public void productMethod() {
        System.out.println("This is productA method");
    }
}

class ProductB extends AbstractProduct {

    @Override
    public void productMethod() {
        System.out.println("This is productB method");
    }
}

class Factory {
    public static AbstractProduct produce(ProductType type) {
        switch (type) {
            case PRODUCT_A:
                return new ProductA();
            case PRODUCT_B:
                return new ProductB();
            default:
                return null;
        }
    }

    public static enum ProductType {
        PRODUCT_A,
        PRODUCT_B,
    }
}