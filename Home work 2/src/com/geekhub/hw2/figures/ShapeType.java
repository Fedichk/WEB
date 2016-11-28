package com.geekhub.hw2.figures;

/**
 * Created by Fedich on 30.10.2016.
 */
enum ShapeType {
    CIRCLE(1, "Circle"),
    SQUARE(2, "Square"),
    RECTANGLE(3, "Rectangle"),
    TRIANGLE(4, "Triangle");

    private java.lang.Integer id;
    private java.lang.String shape;

    ShapeType(Integer id, String shape) {
        this.id = id;
        this.shape = shape;
    }

    public java.lang.String getName() {
        return shape;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public static ShapeType getById(Integer id) {
        for(ShapeType shape : values()) {
            if(shape.id.equals(id))
                return shape;
        }
        return null;
    }
}
