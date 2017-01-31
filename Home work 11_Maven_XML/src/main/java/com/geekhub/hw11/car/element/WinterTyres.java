package com.geekhub.hw11.car.element;

public class WinterTyres extends Tyres {

    public WinterTyres(int size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return "WinterTyres{ " + "size is " + size + " name is " + name + "}";
    }
}
