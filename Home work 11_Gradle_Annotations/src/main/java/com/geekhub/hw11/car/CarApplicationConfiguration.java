package com.geekhub.hw11.car;

import com.geekhub.hw11.car.element.Wheel;
import com.geekhub.hw11.car.element.WinterTyres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.geekhub.hw11.car")
@PropertySource("classpath:car.properties")
public class CarApplicationConfiguration {

    @Bean
    public List<Wheel> listCreator() {
        List<Wheel> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new Wheel(new WinterTyres()));
        }
        return list;
    }
}