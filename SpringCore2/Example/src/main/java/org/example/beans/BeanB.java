package org.example.beans;


public class BeanB implements MyValidator {


    private String name;
    private int value;


    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void myInit(){
        System.out.println("This is a init method");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
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
