package com.geekhub.hw11.translator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.geekhub.hw11.translator")
@PropertySource("classpath:translator.properties")
public class ApplicationConfiguration {
}