package singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: singleton
 * Version: V1.0
 */

// 枚举实现
// effect java 实现例子，不过将类声明成枚举有点奇怪

public enum Singleton_04 {
    INSTANCE;
    public static Singleton_04 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton_01.getInstance().hashCode());
            }).start();
        }
    }
}
