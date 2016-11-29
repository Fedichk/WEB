package com.geekhub.hw6.timer;

public class Test {
    static void test(Appendable obj) throws java.io.IOException {

        long before = System.currentTimeMillis();
        for (int i = 0; i++ < 100000000; i++) {
            obj.append("");
        }
        long after = System.currentTimeMillis();
        System.out.println(obj.getClass().getSimpleName() + ": " + (after - before) + "ms.");
    }
}