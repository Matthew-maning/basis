package com.designpatterns.chain.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: Matthew Ma
 * Date: 2021/8/23
 * Description: com.designpatterns.chain
 * Version: V1.0
 */

public class ChainTest {
    public static void main(String[] args) {
        Message req = new Message();
        req.msg = "Requset:";
        Message resp = new Message();
        resp.msg = "Response:";

        IFilter chain = new FilterChain()
                .add(new Filter1())
                .add(new Filter2())
                .add(new Filter3());
        chain.doFilter(req, resp, chain);
    }
}

class Message {
    String msg;
}

interface IFilter {
    boolean doFilter(Message req, Message resp, IFilter chain);
}

class Filter1 implements IFilter {
    @Override
    public boolean doFilter(Message req, Message resp, IFilter chain) {
        req.msg = req.msg + "req1";
        System.out.println(req.msg);
        chain.doFilter(req, resp, chain);
        resp.msg = resp.msg + ", resp1";
        System.out.println(resp.msg);
        return true;
    }
}

class Filter2 implements IFilter {
    @Override
    public boolean doFilter(Message req, Message resp, IFilter chain) {
        req.msg = req.msg + ", req2";
        System.out.println(req.msg);
        chain.doFilter(req, resp, chain);
        resp.msg = resp.msg + ", resp2";
        System.out.println(resp.msg);
        return true;
    }
}

class Filter3 implements IFilter {
    @Override
    public boolean doFilter(Message req, Message resp, IFilter chain) {
        req.msg = req.msg + ", req3";
        System.out.println(req.msg);
        chain.doFilter(req, resp, chain);
        resp.msg = resp.msg + "resp3";
        System.out.println(resp.msg);
        return true;
    }
}

class FilterChain implements IFilter {
    List<IFilter> list = new ArrayList<>();
    int index = 0;

    public FilterChain add(IFilter filter) {
        list.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Message req, Message resp, IFilter chain) {
        if (index == list.size()) {
             return true;
        }

        IFilter f = list.get(index);
        index++;
        f.doFilter(req, resp, chain);
        return true;
    }
}



