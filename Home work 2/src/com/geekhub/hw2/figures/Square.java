package com.geekhub.hw2.figures;

import static java.lang.Math.*;

/**
 * Created by Fedich on 30.10.2016.
 */
class Square extends Shape {

    private double sideA;

    Square (double sideA){
        this.sideA = sideA;
    }

    @Override
    public double calculateArea() {
        return pow(sideA,2);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideA;
    }

    double calculateAreaOfTriangles() {
        return pow(sideA,2) / 2;
    }

    double calculatePerimeterOfTriangles() {
        return 2 * sideA + sqrt(pow(sideA,2) * 2);
    }
}
