package com.geekhub.hw8.clonecreator;

class Car {

    private int maxCount;
    private String model;
    private String type;
    private String color;
    private int maxSpeed;

    Car(){

    }
    Car(int maxCount, String model, String type, String color, int maxSpeed) {
        this.maxCount = maxCount;
        this.model = model;
        this.type = type;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    int getMaxCount() {
        return maxCount;
    }

    String getModel() {
        return model;
    }

    String getType() {
        return type;
    }

    String getColor() {
        return color;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }
}