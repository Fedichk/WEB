package com.geekhub.hw11.car.element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Wheel {

    private final Tyres tyres;

    @Autowired
    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return " wheels " +
                "with " + tyres.toString();
    }
}