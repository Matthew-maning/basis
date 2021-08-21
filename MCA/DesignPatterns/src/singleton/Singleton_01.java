package singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: singleton
 * Version: V1.0
 */

// 懒汉模式
public class Singleton_01 {
    private static final Singleton_01 sInstance = new Singleton_01();

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        return sInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton_01.getInstance().hashCode());
            }).start();
        }
    }

}
