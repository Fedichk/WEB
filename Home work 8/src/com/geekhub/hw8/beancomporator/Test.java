package com.geekhub.hw8.beancomporator;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Car car1 = new Car(120, "RX-7", "SUV", "black", 230);
        Car car2 = new Car(120, "RX-8", "coupe", "black", 225);

        objectCompare(car1, car2);
    }

    private static void objectCompare(Object obj1, Object obj2) throws IllegalAccessException {
        Class objClass = obj1.getClass();
        Field[] objFields = objClass.getDeclaredFields();
        for (int i = 0; i < objFields.length; i++) {
            if (!objFields[i].isAnnotationPresent(Ignore.class)) {
                objFields[i].setAccessible(true);
                Object tmp1 = objFields[i].get(obj1);
                Object tmp2 = objFields[i].get(obj2);
                System.out.println(objFields[i].getName() + " " + tmp1 + " " + tmp2 + " " + (tmp1.equals(tmp2)));
            }
        }
    }
}
