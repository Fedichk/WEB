package com.geekhub.hw11.translator;

import com.geekhub.hw11.translator.source.FileSourceProvider;
import com.geekhub.hw11.translator.source.SourceLoader;
import com.geekhub.hw11.translator.source.SourceProvider;
import com.geekhub.hw11.translator.source.URLSourceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:translator.properties")
public class ApplicationConfiguration {

    @Bean
    public FileSourceProvider fileSourceProvider(){
        return new FileSourceProvider();
    }

    @Bean
    public URLSourceProvider urlSourceProvider(){
        return new URLSourceProvider();
    }

    @Bean
    public SourceLoader sourceLoader(List<SourceProvider> list){
        list.add(fileSourceProvider());
        list.add(urlSourceProvider());
        return new SourceLoader(list);
    }

    @Bean
    public Translator translator(URLSourceProvider urlSourceProvider){
        return new Translator(urlSourceProvider);
    }
}
