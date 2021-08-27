package com.designpatterns.singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.singleton
 * Version: V1.0
 */

// 枚举实现
// effect java 实现例子，不过将类声明成枚举有点奇怪

public enum SingletonV4 {
    INSTANCE;
    public static SingletonV4 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingletonV4.getInstance().hashCode());
            }).start();
        }
    }
}
