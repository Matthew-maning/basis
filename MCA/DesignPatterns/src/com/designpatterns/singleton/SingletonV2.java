package com.designpatterns.singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.singleton
 * Version: V1.0
 */

//DCL

public class SingletonV2 {
    private static volatile SingletonV2 sInstance = null;

    private SingletonV2() {
    }

    public static SingletonV2 getInstance() {
        if (sInstance == null) {
            synchronized (SingletonV2.class) {
                if (sInstance == null) {
                    sInstance = new SingletonV2();
                }
            }
        }
        return sInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingletonV2.getInstance().hashCode());
            }).start();
        }
    }
}
