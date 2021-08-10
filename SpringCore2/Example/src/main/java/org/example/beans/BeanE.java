package org.example.beans;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements MyValidator {
    private String name;
    private int value;

    public BeanE(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("The postConstruct method has done ");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("The preDestroy method has done");
    }

    @Override
    public void validate(String beanName) {
        if(this.name == null || name.isEmpty()){
            System.out.println(beanName + ": Name can't be null");
        }
        if(this.value < 0){
            System.out.println(beanName + ": Value can't be under zero");
        }
    }
}
