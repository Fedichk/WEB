package com.geekhub.hw11.car.element;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

    @Value("${engine.capacity}")
    private int engineCapacity;

    @Override
    public String toString() {
        return "capacity = " + engineCapacity;
    }
}