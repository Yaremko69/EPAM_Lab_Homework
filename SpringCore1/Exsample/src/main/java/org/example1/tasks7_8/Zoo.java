package org.example1.tasks7_8;

import org.example1.tasks7_8.animals.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    @Autowired
    private List<Animal> animals;

    public void animalsVoice(){
        for (Animal a: animals){
            a.voice();
        }
    }

}
