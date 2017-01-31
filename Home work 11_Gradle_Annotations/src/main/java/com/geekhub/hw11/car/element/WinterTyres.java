package com.geekhub.hw11.car.element;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WinterTyres extends Tyres {

    @Value("${winterTyres.size}")
    private int size;
    @Value("${winterTyres.name}")
    private String name;

    @Override
    public String toString() {
        return "winter tyres {" + "size is " + size + " name is " + name + "}";
    }
}
