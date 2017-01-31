package com.geekhub.hw11.car.element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Wheel {

    @Autowired
    @Qualifier("winterTyres")
    private Tyres tyres;

    @Override
    public String toString() {
        return " wheels " +
                "with " + tyres.toString();
    }
}