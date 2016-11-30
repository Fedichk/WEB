package com.geekhub.hw6.carsort;

public class Car implements Comparable<Car> {
    String name;
    int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car obj) {
        Car entry = obj;
        int result = name.compareTo(entry.name);
        if (result != 0) {
            return result;
        }
        result = price - entry.price;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}

