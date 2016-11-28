package com.geekhub.hw2.figures;
import java.util.Scanner;

/**
 * Created by Fedich on 30.10.2016.
 */
public class ShapeApplication {
    public static void main(String[] args) {

        Integer shapeNumber = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, select the shape number: ");

        for(ShapeType shape : ShapeType.values()) {
            System.out.println(shape.getId() + ". " + shape.getName());
        }
        while (shapeNumber < 1 || shapeNumber > 4  ) {

            try {
            shapeNumber = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }
            if (shapeNumber > 0 && shapeNumber < 5) {
                break;
            }
            System.out.println("Shape number is incorrect. Please, select the shape number:");
        }

        ShapeType shape = ShapeType.getById(shapeNumber);

        Shape figure = ShapeSelect.select(shape);
    }
}
