package com.geekhub.hw2.figures;

import static java.lang.Math.*;

/**
 * Created by Fedich on 30.10.2016.
 */
class Rectangle extends Shape {
    private double sideA;
    private double sideB;

    Rectangle (double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * sideA + 2 * sideB;
    }

    double calculateAreaOfTriangles() {
        return sideA * sideB / 2;
    }

    double calculatePerimeterOfTriangles() {
        return sideA + sideB + sqrt(pow(sideA,2) + pow(sideA,2));
    }
}
