package com.geekhub.hw11.translator;

import com.geekhub.hw11.translator.source.SourceLoader;
import com.geekhub.hw11.translator.source.SourceLoadingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException, TranslateException, SourceLoadingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("translatorContext.xml");
        SourceLoader sourceLoader = context.getBean(SourceLoader.class);
        Translator translator = context.getBean(Translator.class);
        Scanner scanner = new Scanner(System.in);

        String command = scanner.next();
        while (!"exit".equals(command)) {
            String source = sourceLoader.loadSource(command);
            String translation = translator.translate(source);
            System.out.println("Original: " + source);
            System.out.println("Translation: " + translation);
            command = scanner.next();
        }
    }
}