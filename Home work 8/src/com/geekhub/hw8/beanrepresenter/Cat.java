package com.geekhub.hw8.beanrepresenter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Ignore {}

public class Cat {

    private String color;
    @Ignore
    private int age;
    private int legCount;
    private int furLength;

    public Cat(String color, int age, int legCount, int furLength) {
        this.color = color;
        this.age = age;
        this.legCount = legCount;
        this.furLength = furLength;
   }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public int getLegCount() {
        return legCount;
    }

    public int getFurLength() {
        return furLength;
    }
}