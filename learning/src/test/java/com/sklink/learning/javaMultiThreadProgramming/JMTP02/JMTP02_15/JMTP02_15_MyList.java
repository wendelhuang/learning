package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_15;

import java.util.ArrayList;
import java.util.List;

public class JMTP02_15_MyList {
    private List list = new ArrayList<>();

    synchronized public void add(String username) {
        System.out.println(String.format("ThreadName = %s执行了add方法", Thread.currentThread().getName()));
        list.add(username);
        System.out.println(String.format("ThreadName = %s退出了add方法", Thread.currentThread().getName()));
    }

    synchronized public int getSize() {
        System.out.println(String.format("ThreadName = %s执行了getSize方法", Thread.currentThread().getName()));
        int size = list.size();
        System.out.println(String.format("ThreadName = %s退出了getSize方法", Thread.currentThread().getName()));
        return size;
    }
}
