package com.designpatterns.builder;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/21
 * Description: com.designpatterns.builder
 * Version: V1.0
 */

public interface IComplexBuilder {
    IComplexBuilder buildPart1(int x, int y, int z);
    IComplexBuilder buildPart2(float x, float y, float z);
    IComplexBuilder buildPart3(long x, long y, long z);
    IComplexBuilder buildPart4(String x, String y, String z);
    ComplexObject build();
}
