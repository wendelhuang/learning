package com.sklink.learning.javaMultiThreadProgramming.JMTP02.JMTP02_16;

import java.util.ArrayList;
import java.util.List;

public class JMTP02_16_MyList {
    private List list = new ArrayList<>();

    synchronized public void add(String username) {
        list.add(username);
    }

    synchronized public int getSize() {
        return list.size();
    }
}
