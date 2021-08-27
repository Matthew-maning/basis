package com.designpatterns.chain.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.chain
 * Version: V1.0
 */

// chain of responsibility

public class ChainTest {
    public static void main(String[] args) {
        IFilter chain = new FilterChain()
                .add(new Filter1())
                .add(new Filter2())
                .add(new Filter3());
        System.out.println(chain.doFilter("asddsgd"));
    }
}

interface IFilter {
    boolean doFilter(String value);
}

class Filter1 implements IFilter {
    @Override
    public boolean doFilter(String value) {
        System.out.println("Filter1 doFilter()");
        return value.indexOf("aa") >= 0 ? false : true;
    }
}

class Filter2 implements IFilter {
    @Override
    public boolean doFilter(String value) {
        System.out.println("Filter2 doFilter()");
        return value.indexOf("bb") >= 0 ? false : true;
    }
}

class Filter3 implements IFilter {
    @Override
    public boolean doFilter(String value) {
        System.out.println("Filter3 doFilter()");
        return value.indexOf("cc") >= 0 ? false : true;
    }
}

class FilterChain implements IFilter {
    List<IFilter> list = new ArrayList<>();

    public FilterChain add(IFilter filter) {
        list.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(String value) {
        for (IFilter filter : list) {
            if (!filter.doFilter(value)) {
                return false;
            }
        }
        return true;
    }
}
