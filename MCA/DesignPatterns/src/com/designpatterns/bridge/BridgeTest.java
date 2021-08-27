package com.designpatterns.bridge;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.bridge.v1
 * Version: V1.0
 */

public class BridgeTest {
    public static void main(String[] args) {
        Gift g1 = new GoodGift(new Book());
        Gift g2 = new BadGift(new Flower());
        g1.print();
        g2.print();
    }
}

class Gift {
    String giftKind;
    GiftImpl impl;

    void print() {
        System.out.println("GitKind=" + giftKind + ", name=" + impl.name);
    }
 }

class GiftImpl {
    String name;
    void getName() {
        System.out.println("gift name:" + name);
    }
}

class GoodGift extends Gift {
    public GoodGift(GiftImpl impl) {
        this.impl = impl;
        this.giftKind = "good";
    }
}

class BadGift extends Gift {
    public BadGift(GiftImpl impl) {
        this.impl = impl;
        this.giftKind = "bad";
    }
}

class Book extends GiftImpl {
    public Book() {
        this.name = "book";
    }
}

class Flower extends GiftImpl {
    public Flower() {
        this.name = "flower";
    }
}



