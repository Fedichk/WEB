package com.geekhub.hw8.beancomporator;

class Car {

    private int maxCount;
    private String model;
    @Ignore
    private String type;
    private String color;
    private int maxSpeed;

    Car(int maxCount, String model, String type, String color, int maxSpeed) {
        this.maxCount = maxCount;
        this.model = model;
        this.type = type;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

}