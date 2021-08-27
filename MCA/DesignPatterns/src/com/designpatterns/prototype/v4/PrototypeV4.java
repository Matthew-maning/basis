package com.designpatterns.prototype.v4;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.prototype.v4
 * Version: V1.0
 */

// StringBuffer/StringBuilder 没有实现clone 接口

public class PrototypeV4 {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println("p1.loc == p2.loc? " + (p1.loc == p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
        System.out.println(p1.loc.street.hashCode());
        System.out.println(p2.loc.street.hashCode());

    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location(new StringBuilder("bj"), 22);
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location)loc.clone();
        return p;
    }
}

class Location implements Cloneable {
    StringBuilder street;
    int roomNo;

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }

    public Location(StringBuilder street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
//        Location l = new Location(null, this.roomNo);
//        l.street = new StringBuilder(this.street.toString());
//        return l;
    }
}

