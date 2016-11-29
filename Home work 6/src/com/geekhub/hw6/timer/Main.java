package com.geekhub.hw6.timer;

import static com.geekhub.hw6.timer.Test.test;
import static com.geekhub.hw6.timer.TestString.testString;

public class Main {

    public static void main(String[] args) {
        try {
            test(new StringBuffer(""));
            test(new StringBuilder(""));
            testString(new String(""));
        } catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

