package com.geekhub.hw11.car.element;

public class Wheel {
    private Tyres tyres;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return " wheels " +
                "with " + tyres.toString();
    }
}