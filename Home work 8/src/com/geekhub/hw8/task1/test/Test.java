package com.geekhub.hw8.task1.test;

import com.geekhub.hw8.task1.json.JsonSerializaer;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Cat cat = new Cat();
        cat.setColor(Color.GRAY);
        cat.setAge(4);
        cat.setName("Tom");

        List<Integer> whiskers = cat.getWhiskers();
        whiskers.add(1);
        whiskers.add(2);
        whiskers.add(3);
        whiskers.add(4);
        whiskers.add(5);
        whiskers.add(6);

        cat.setBirthDate(LocalDate.now());
        cat.getPaws().put("front-left", new Paw(23, Color.GRAY));
        cat.getPaws().put("front-right", new Paw(24, Color.WHITE));
        cat.getPaws().put("back-left", new Paw(23, Color.BLACK));
        cat.getPaws().put("back-right", new Paw(22, Color.GRAY));

        Cat cat1 = new Cat();
        cat1.setColor(Color.BLACK);
        cat1.setAge(2);
        cat1.setName("Tam");

        Cat cat2 = new Cat();
        cat2.setColor(Color.RED);
        cat2.setAge(5);
        cat2.setName("Tim");



        List <Cat> ch = new ArrayList<>();
        ch.add(cat1);
        ch.add(cat2);

        cat.setChildren(ch);

        System.out.println(JsonSerializaer.serialize(cat));
    }
}