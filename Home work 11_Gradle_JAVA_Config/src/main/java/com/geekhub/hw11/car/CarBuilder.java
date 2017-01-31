package com.geekhub.hw11.car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarBuilder {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CarConfiguration.class);
        System.out.println(context.getBean(Car.class));
    }
}