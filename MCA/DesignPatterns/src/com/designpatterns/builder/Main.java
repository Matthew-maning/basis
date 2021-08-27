package com.designpatterns.builder;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.builder
 * Version: V1.0
 */

public class Main {
    public static void main(String[] args) {
        ComplexObject o = new ComplexBuilder()
                .buildPart1(1,2,3)
                .buildPart2(1.1f, 2.2f, 3.3f)
                .buildPart3(100, 200, 300)
                .buildPart4("aaa", "bbb", "ccc")
                .build();
        System.out.println(o);
    }
}
