package com.geekhub.hw11.car.element;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SummerTyres extends Tyres {

    @Value("${summerTyres.size}")
    private int size;
    @Value("${summerTyres.size}")
    private String name;

    @Override
    public String toString() {
        return "summer tyres {" + "size is " + size + ", name is " + name + "}";
    }
}