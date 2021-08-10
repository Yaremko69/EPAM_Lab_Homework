package org.example1.tasks7_8.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class theAnimals {

    private Animal cat;
    private Animal cow;
    private Animal dog;

    @Autowired
    public theAnimals (Animal cat, @Qualifier("cow") Animal cow, @Qualifier("dog") Animal dog){
        this.cat = cat;
        this.cow = cow;
        this.dog = dog;
    }

    public void animalsVoice(){
        cat.voice();
        cow.voice();
        dog.voice();
    }
}
