package com.geekhub.hw8.beanrepresenter;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {

        Cat cat = new Cat("multicolor", 3, 4, 35);
        Car car = new Car("black", 190, "SUV", "RX-7");
        Human human = new Human(180, "male", 22, 75);

        getInformation(cat);
        getInformation(car);
        getInformation(human);
    }

    private static void getInformation(Object obj) throws IllegalAccessException {
        Class objClass = obj.getClass();
        Field[] objFields = objClass.getDeclaredFields();
        System.out.println(objClass.getSimpleName());
        for (Field field : objFields) {
            if (!field.isAnnotationPresent(Ignore.class)) {
                field.setAccessible(true);
                System.out.println(field.getName() + " " + field.get(obj));
            }
        }
    }
}