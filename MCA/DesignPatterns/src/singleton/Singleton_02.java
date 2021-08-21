package singleton;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: singleton
 * Version: V1.0
 */

//DCL

public class Singleton_02 {
    private static volatile Singleton_02 sInstance = null;

    private Singleton_02() {
    }

    public static Singleton_02 getInstance() {
        if (sInstance == null) {
            synchronized (Singleton_02.class) {
                if (sInstance == null) {
                    sInstance = new Singleton_02();
                }
            }
        }
        return sInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton_01.getInstance().hashCode());
            }).start();
        }
    }
}
