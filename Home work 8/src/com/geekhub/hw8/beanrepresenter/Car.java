package com.geekhub.hw8.beanrepresenter;

class Car {

    @Ignore
    private String color;
    private int maxSpeed;
    private String type;
    private String model;

    Car(String color, int maxSpeed, String type, String model) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.type = type;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }
}
