package com.geekhub.hw2.figures;

import static java.lang.Math.*;

/**
 * Created by Fedich on 30.10.2016.
 */
class Circle extends Shape {

    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return pow(radius,2) * PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}
