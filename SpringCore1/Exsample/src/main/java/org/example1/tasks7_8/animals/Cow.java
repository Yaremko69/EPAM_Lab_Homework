package org.example1.tasks7_8.animals;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Qualifier("cow")
@Component
@Order(2)
public class Cow implements Animal {

    public void voice(){
        System.out.println("Moo");
    }
}
