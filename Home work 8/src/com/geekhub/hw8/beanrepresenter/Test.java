package com.geekhub.hw8.beanrepresenter;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {

        Cat cat = new Cat("multicolor", 3, 4, 35);
        Car car = new Car("black", 190, "SUV", "RX-7");
        Human human = new Human(180, "male", 22, 75);

        Class catClass = cat.getClass();
        Class carClass = Car.class;
        Class humanClass = Human.class;

        Field[] catFields = catClass.getDeclaredFields();
        Field[] carFields = carClass.getDeclaredFields();
        Field[] humanFields = humanClass.getDeclaredFields();

        System.out.println(catClass.getName());
        for (Field field : catFields) {
            if (field.isAnnotationPresent(Ignore.class)) {
            } else {
                field.setAccessible(true);
                System.out.println(field.getName() + " " + field.get(cat));
            }
        }
        System.out.println(carClass.getName());
        for (Field field : carFields) {
            if (field.isAnnotationPresent(Ignore.class)) {
            } else {
                field.setAccessible(true);
                System.out.println(field.getName() + " " + field.get(car));
            }
        }
        System.out.println(humanClass.getName());
        for (Field field : humanFields) {
            if (field.isAnnotationPresent(Ignore.class)) {
            } else {
                field.setAccessible(true);
                System.out.println(field.getName() + " " + field.get(human));
            }
        }
    }
}
