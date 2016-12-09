package com.geekhub.hw8.beanrepresenter;

class Human {

    private int height;
    private String gender;
    @Ignore
    private int age;
    private int weight;

    Human(int height, String gender, int age, int weight) {
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
