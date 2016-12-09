package com.geekhub.hw8.beancomporator;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Car car1 = new Car(120, "RX-7", "SUV", "black", 230);
        Car car2 = new Car(120, "RX-8", "coupe", "black", 225);

        objectCompare(car1, car2);
    }

    private static void objectCompare(Object obj1, Object obj2) throws IllegalAccessException {
        Class obj1Class = obj1.getClass();
        Class obj2Class = obj2.getClass();
        Field[] obj1Fields = obj1Class.getDeclaredFields();
        Field[] obj2Fields = obj2Class.getDeclaredFields();
        for (int i = 0; i < obj1Fields.length; i++) {
            if (!obj1Fields[i].isAnnotationPresent(Ignore.class)) {
                obj1Fields[i].setAccessible(true);
                obj2Fields[i].setAccessible(true);
                Object tmp1 = obj1Fields[i].get(obj1);
                Object tmp2 = obj2Fields[i].get(obj2);
                System.out.println(obj1Fields[i].getName() + " " + tmp1 + " " + tmp2 + " " + (tmp1.equals(tmp2)));
            }
        }
    }
}
