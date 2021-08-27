package com.designpatterns.facade;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.facade
 * Version: V1.0
 */

public class FacadeTest {
    public static void main(String[] args) {
        Facecade f = new Facecade();
        f.action1();
        f.action2();
        f.action3();
    }
}

class Facecade {
    private SubSystem1 ss1 = new SubSystem1();
    private SubSystem2 ss2 = new SubSystem2();
    private SubSystem3 ss3 = new SubSystem3();

    void action1() {
        ss1.action();
    }

    void action2() {
        ss2.action();
    }

    void action3() {
        ss3.action();
    }
}

class SubSystem1 {
    void action() {
        System.out.println("SubSystem1 do action");
    }
}

class SubSystem2 {
    void action() {
        System.out.println("SubSystem2 do action");
    }
}

class SubSystem3 {
    void action() {
        System.out.println("SubSystem3 do action");
    }
}