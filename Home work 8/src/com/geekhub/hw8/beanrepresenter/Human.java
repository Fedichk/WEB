package com.geekhub.hw8.beanrepresenter;

public class Human {

    private int height;
    private String gender;
    private int age;
    private int weight;

    public Human(int height, String gender, int age, int weight) {
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }
}
