package com.designpatterns.builder;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.builder
 * Version: V1.0
 */

public class ComplexObject {
    Part1 p1;
    Part2 p2;
    Part3 p3;
    Part4 p4;

    protected ComplexObject() {
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }
}

class Part1 {
    int ix, iy, iz;

    public Part1(int ix, int iy, int iz) {
        this.ix = ix;
        this.iy = iy;
        this.iz = iz;
    }

    @Override
    public String toString() {
        return "Part1{" +
                "ix=" + ix +
                ", iy=" + iy +
                ", iz=" + iz +
                '}';
    }
}

class Part2 {
    float fx, fy, fz;

    public Part2(float fx, float fy, float fz) {
        this.fx = fx;
        this.fy = fy;
        this.fz = fz;
    }

    @Override
    public String toString() {
        return "Part2{" +
                "fx=" + fx +
                ", fy=" + fy +
                ", fz=" + fz +
                '}';
    }
}

class Part3 {
    long lx, ly, lz;

    public Part3(long lx, long ly, long lz) {
        this.lx = lx;
        this.ly = ly;
        this.lz = lz;
    }

    @Override
    public String toString() {
        return "Part3{" +
                "lx=" + lx +
                ", ly=" + ly +
                ", lz=" + lz +
                '}';
    }
}

class Part4 {
    String sx, sy, sz;

    public Part4(String sx, String sy, String sz) {
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
    }

    @Override
    public String toString() {
        return "Part4{" +
                "sx='" + sx + '\'' +
                ", sy='" + sy + '\'' +
                ", sz='" + sz + '\'' +
                '}';
    }
}

