package com.geekhub.hw2.figures;

import static java.lang.Math.*;

/**
 * Created by Fedich on 30.10.2016.
 */
class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    Triangle (double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        double halfOfTrianglePerimeter = (sideA + sideB + sideC) / 2;
        return sqrt(halfOfTrianglePerimeter * (halfOfTrianglePerimeter - sideA) * (halfOfTrianglePerimeter - sideB) * (halfOfTrianglePerimeter - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}
