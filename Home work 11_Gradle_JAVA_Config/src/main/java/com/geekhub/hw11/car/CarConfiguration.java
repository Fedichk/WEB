package com.geekhub.hw11.car;

import com.geekhub.hw11.car.element.Engine;
import com.geekhub.hw11.car.element.SummerTyres;
import com.geekhub.hw11.car.element.Wheel;
import com.geekhub.hw11.car.element.WinterTyres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CarConfiguration {

    @Bean
    public SummerTyres summerTyres() {
        return new SummerTyres(17, "Dunlop");
    }

    @Bean
    public WinterTyres winterTyres() {
        return new WinterTyres(16, "Nokian");
    }

    @Bean
    public Wheel wheel (){
        return new Wheel(summerTyres());
    }

    @Bean
    public Engine engine(){
        return new Engine(2000);
    }

    @Bean
    public List<Wheel> listCreator(Wheel wheel) {
        List<Wheel> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(wheel);
        }
        return list;
    }

    @Bean
    public Car car(){
        return new Car(listCreator(wheel()), engine());
    }
}