package com.geekhub.hw8.clonecreator;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Car car = new Car(120, "RX-7", "SUV", "black", 230);
        Car clon = (Car) cloning(car);
        System.out.println(clon.getModel());
        System.out.println(clon.getType());

    }

    private static Object cloning(Object obj) throws IllegalAccessException, InstantiationException {
        Class objClass = obj.getClass();
        Object clone = objClass.newInstance();
        Field[] objFields = objClass.getDeclaredFields();
        for (Field field : objFields) {
            field.setAccessible(true);
            field.set(clone, field.get(obj));
        }
        return clone;
    }

}


