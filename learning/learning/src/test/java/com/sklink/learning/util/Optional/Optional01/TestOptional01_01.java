package com.sklink.learning.util.Optional.Optional01;


import org.junit.Test;

import java.util.Optional;

public class TestOptional01_01 {
    class M {
        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        private String a;
    }

    @Test
    public void test() {
        M m = new M();
        m.setA("a");

        System.out.println(Optional.ofNullable(m).map(M::getA).getClass());

        Optional<M> o1 = Optional.ofNullable(m);
        Optional<Optional> o2 = Optional.ofNullable(o1);
        System.out.println(o2.flatMap(t -> t).get().getClass());
        Optional<Optional> o3 = Optional.ofNullable(o2);
        Optional<Optional> o4 = Optional.ofNullable(o3);
        System.out.println(o4.flatMap(t -> t).get().getClass());
        System.out.println(Optional.ofNullable(m).flatMap(t -> Optional.ofNullable(t.getA())).getClass());
    }
}
