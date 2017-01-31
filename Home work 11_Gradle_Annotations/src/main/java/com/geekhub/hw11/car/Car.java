package com.geekhub.hw11.car;

import com.geekhub.hw11.car.element.Engine;
import com.geekhub.hw11.car.element.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Car {

    @Autowired
    @Qualifier("listCreator")
    private List<Wheel> wheels;

    @Autowired
    private Engine engine;

    @Override
    public String toString() {
        return "Car has " + wheels.size() +
                wheels.get(0).toString() +
                " and engine " + engine;
    }
}