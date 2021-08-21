package singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: singleton
 * Version: V1.0
 */

// 静态内部类实现
// 静态内部类在外部类被加载时不会加载，只有当调用getInstance() 时才会加载单例对象
// 如果自定义classloader 可能会产生多个实例


public class Singleton_03 {
    private Singleton_03() {
    }

    public static class Instance {
        public static final Singleton_03 INSTANCE = new Singleton_03();
    }

    public static Singleton_03 getInstance() {
        return Instance.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton_01.getInstance().hashCode());
            }).start();
        }
    }
}
