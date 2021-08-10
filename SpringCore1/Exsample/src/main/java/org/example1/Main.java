package org.example1;

import org.example1.tasks1_4.config.AppConfig1;
import org.example1.tasks1_4.config.AppConfig2;
import org.example1.tasks5_6.AppConfig3;
import org.example1.tasks7_8.AppConfig4;
import org.example1.tasks7_8.Zoo;
import org.example1.tasks7_8.animals.theAnimals;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class, AppConfig3.class, AppConfig4.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        
        context.getBean(Zoo.class).animalsVoice();
        context.getBean(theAnimals.class).animalsVoice();
    }

}
