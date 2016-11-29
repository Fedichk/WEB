package com.geekhub.hw6.timer;

public class TestString {
    static void testString(String obj) throws java.io.IOException {

        long before = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            obj += "";
        }
        long after = System.currentTimeMillis();
        System.out.println("String" + ": " + (after - before) + "ms.");
    }
}
