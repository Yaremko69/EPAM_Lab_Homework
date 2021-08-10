package org.example;

import org.example.configs.Config1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        for(String name: context.getBeanDefinitionNames()){
            System.out.println(name);
        }

    }
}
