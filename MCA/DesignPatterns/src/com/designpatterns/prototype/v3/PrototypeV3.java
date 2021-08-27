package com.designpatterns.prototype.v3;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.prototype.v3
 * Version: V1.0
 */

// 相比较于V2 版本，p1 多次改变 p1.loc.street p2不会改变


public class PrototypeV3 {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println("afert change p1 to sh p1=:" + p1.loc);
        System.out.println("afert change p1 to sh p2=:" + p2.loc);

        p1.loc.street.replace("sh", "sz");
        System.out.println("afert change p1 to sz:" + p1.loc);
        System.out.println("afert change p1 to sz:" + p2.loc);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location)loc.clone();
        return p;
    }
}

class Location implements Cloneable {
    String street;
    int roomNo;

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

