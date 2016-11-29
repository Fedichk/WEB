package com.geekhub.hw6.carsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Audi", 20000));
        cars.add(new Car("Audi",  25000));
        cars.add(new Car("Audi", 15000));
        cars.add(new Car("Audi",  12000));
        cars.add(new Car("Banes", 28000));
        cars.add(new Car("Banes",  23000));
        cars.add(new Car("Banes", 45000));
        cars.add(new Car("Banes",  53000));

        cars.sort(Comparator.comparing(Car::getName)
                .thenComparing(Car::getPrice));
        cars.forEach((car) -> System.out.println("Name: " + car.getName() + ", price: " + car.getPrice()));

    }
}
