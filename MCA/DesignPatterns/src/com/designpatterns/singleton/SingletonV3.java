package com.designpatterns.singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.singleton
 * Version: V1.0
 */

// 静态内部类实现
// 静态内部类在外部类被加载时不会加载，只有当调用getInstance() 时才会加载单例对象
// 如果自定义classloader 可能会产生多个实例


public class SingletonV3 {
    private SingletonV3() {
    }

    public static class Instance {
        public static final SingletonV3 INSTANCE = new SingletonV3();
    }

    public static SingletonV3 getInstance() {
        return Instance.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(SingletonV3.getInstance().hashCode());
            }).start();
        }
    }
}
