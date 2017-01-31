package com.geekhub.hw11.car.element;

public class Engine {
    private int engineCapacity;

    public Engine(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "capacity = " + engineCapacity;
    }
}