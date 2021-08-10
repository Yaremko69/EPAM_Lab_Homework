package org.example1.tasks7_8.animals;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(1)
public class Cat implements Animal {
    public void voice(){
        System.out.println("May");
    }
}
