package com.designpatterns.builder;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.builder
 * Version: V1.0
 */

public class ComplexBuilder implements IComplexBuilder {
    private ComplexObject o = new ComplexObject();

    @Override
    public IComplexBuilder buildPart1(int x, int y, int z) {
        o.p1 = new Part1(x, y, z);
        return this;
    }

    @Override
    public IComplexBuilder buildPart2(float x, float y, float z) {
        o.p2 = new Part2(x, y, z);
        return this;
    }

    @Override
    public IComplexBuilder buildPart3(long x, long y, long z) {
        o.p3 = new Part3(x, y, z);
        return this;
    }

    @Override
    public IComplexBuilder buildPart4(String x, String y, String z) {
        o.p4 = new Part4(x, y, z);
        return this;
    }

    @Override
    public ComplexObject build() {
        return o;
    }
}
