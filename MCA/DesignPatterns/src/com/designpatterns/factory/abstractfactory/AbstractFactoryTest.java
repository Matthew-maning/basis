package com.designpatterns.factory.abstractfactory;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.factory.abstractfactory
 * Version: V1.0
 */

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory = new FoodFactory();
        AbstractProduct productA = factory.createA();
        AbstractProduct productB = factory.createB();
        productA.m();
        productB.m();

        factory = new DrinkFactory();
        productA = factory.createA();
        productB = factory.createB();
        productA.m();
        productB.m();
    }
}

abstract class AbstractProduct {
    String productType;
    abstract void m();
}

abstract class Food extends AbstractProduct {
    String foodType;
    protected Food() {
        productType = "food";
    }
}

class Bread extends Food {
    protected Bread() {
        this.foodType = "bread";
    }

    @Override
    void m() {
        System.out.println("M: productType=" + productType + ", FoodType=" + foodType);
    }
}

class Noodle extends Food {
    protected Noodle() {
        this.foodType = "noodle";
        System.out.println("new type=" + productType + ", foodType=" + foodType);
    }

    @Override
    void m() {
        System.out.println("M: productType=" + productType + ", FoodType=" + foodType);
    }
}

abstract class Drink extends AbstractProduct {
    String drinkType;
    protected Drink() {
        this.productType = "drink";
    }
}

class Milk extends Drink {
    protected Milk() {
        drinkType = "milk";
    }

    @Override
    void m() {
        System.out.println("M: productType=" + productType + ", drinkType=" + drinkType);
    }
}

class Water extends Drink {

    protected Water() {
        drinkType = "water";
    }

    @Override
    void m() {
        System.out.println("M: productType=" + productType + ", drinkType=" + drinkType);
    }
}

abstract class AbstractFactory {
    public abstract AbstractProduct createA();
    public abstract AbstractProduct createB();
}


class FoodFactory extends AbstractFactory {
    @Override
    public AbstractProduct createA() {
        return new Bread();
    }

    @Override
    public AbstractProduct createB() {
        return new Noodle();
    }
}

class DrinkFactory extends  AbstractFactory {
    @Override
    public AbstractProduct createA() {
        return new Water();
    }

    @Override
    public AbstractProduct createB() {
        return new Milk();
    }
}
