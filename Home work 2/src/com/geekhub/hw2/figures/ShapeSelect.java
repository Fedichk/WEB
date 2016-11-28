package com.geekhub.hw2.figures;

import java.util.Scanner;

/**
 * Created by Fedich on 30.10.2016.
 */
class ShapeSelect {

    static Shape select(ShapeType shape) {

        Scanner sc = new Scanner(System.in);
        switch (shape){
            case CIRCLE:
                double rad;
                System.out.println("Please, enter the circle radius:");
                rad = Integer.parseInt(sc.nextLine());
                Circle circle = new Circle(rad);
                System.out.println("The circle area is: " + circle.calculateArea());
                System.out.println("The circle perimeter is: " + circle.calculatePerimeter());
                break;
            case SQUARE:
                double aSide;
                System.out.println("Please, enter the square side length:");
                aSide = Integer.parseInt(sc.nextLine());
                Square square = new Square(aSide);
                System.out.println("The square area is: " + square.calculateArea());
                System.out.println("The square perimeter is: " + square.calculatePerimeter());
                System.out.println("The square half triangle area is: " + square.calculateAreaOfTriangles());
                System.out.println("The square half triangle perimeter is: " + square.calculatePerimeterOfTriangles());
                break;
            case RECTANGLE:
                double bSide;
                double cSide;
                System.out.println("Please, enter the rectangle side 1 length:");
                bSide = Integer.parseInt(sc.nextLine());
                System.out.println("Please, enter the rectangle side 2 length:");
                cSide = Integer.parseInt(sc.nextLine());
                Rectangle rectangle = new Rectangle(bSide, cSide);
                System.out.println("The rectangle area is: " + rectangle.calculateArea());
                System.out.println("The rectangle perimeter is: " + rectangle.calculatePerimeter());
                System.out.println("The rectangle half triangle area is: " + rectangle.calculateAreaOfTriangles());
                System.out.println("The rectangle half triangle perimeter is: " + rectangle.calculatePerimeterOfTriangles());
                break;
            case TRIANGLE:
                double dSide;
                double eSide;
                double fSide;
                System.out.println("Please, enter the triangle side 1 length:");
                dSide = Integer.parseInt(sc.nextLine());
                System.out.println("Please, enter the triangle side 2 length:");
                eSide = Integer.parseInt(sc.nextLine());
                System.out.println("Please, enter the triangle side 3 length:");
                fSide = Integer.parseInt(sc.nextLine());
                Triangle triangle = new Triangle(dSide, eSide, fSide);
                System.out.println("The rectangle area is: " + triangle.calculateArea());
                System.out.println("The rectangle perimeter is: " + triangle.calculatePerimeter());
                break;
            default:
                break;
        }

        return null;
    }
}
