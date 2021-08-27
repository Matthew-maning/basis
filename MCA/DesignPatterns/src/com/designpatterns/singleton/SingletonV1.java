package com.designpatterns.singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.singleton
 * Version: V1.0
 */

// 懒汉模式
public class SingletonV1 {
    private static final SingletonV1 sInstance = new SingletonV1();

    private SingletonV1() {
    }

    public static SingletonV1 getInstance() {
        return sInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(SingletonV2.getInstance().hashCode());
            }).start();
        }
    }

}
