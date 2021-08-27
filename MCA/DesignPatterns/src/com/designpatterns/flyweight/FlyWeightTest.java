package com.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.flyweight
 * Version: V1.0
 */

public class FlyWeightTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Element e = Element.obtain();
        }
    }
}

class Element {
    private static List<Element> list = new ArrayList<>();
    String name;
    boolean use;

    static  {
        for (int i = 0; i < 5; i++) {
            list.add(new Element());
        }
    }

    public static Element obtain() {
        for (Element e : list) {
            if (!e.use) {
                e.use = true;
                System.out.println("element in pool");
                return e;
            }
        }

        Element e =  new Element();
        e.use = false;
        System.out.println("element not in pool");
        return e;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                '}';
    }
}
