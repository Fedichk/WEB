package com.geekhub.hw11.car.element;

public class SummerTyres extends Tyres {

    public SummerTyres(int size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return "summer tyres {" + "size is " + size + ", name is " + name + "}";
    }
}