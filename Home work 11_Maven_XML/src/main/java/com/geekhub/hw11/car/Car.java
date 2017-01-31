package com.geekhub.hw11.car;

import com.geekhub.hw11.car.element.Engine;
import com.geekhub.hw11.car.element.Wheel;

import java.util.List;

public class Car {
    private List<Wheel> wheels;
    private Engine engine;

    public Car(List<Wheel> wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car has " + wheels.size() +
                wheels.get(0).toString() +
                " and engine " + engine;
    }
}