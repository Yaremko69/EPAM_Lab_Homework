package org.example1.tasks7_8.animals;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Qualifier("dog")
@Component
@Order(3)
public class Dog implements Animal {
    public void voice(){
        System.out.println("Bark");
    }
}
