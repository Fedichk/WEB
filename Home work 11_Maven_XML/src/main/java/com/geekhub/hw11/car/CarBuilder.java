package com.geekhub.hw11.car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarBuilder {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("carContext.xml");
        System.out.println(context.getBean(Car.class));
    }
}