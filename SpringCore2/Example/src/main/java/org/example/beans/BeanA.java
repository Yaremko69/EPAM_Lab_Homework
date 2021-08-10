package org.example.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean, MyValidator {
    private String name;
    private int value;


    public BeanA(String name, int value) {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("The afterPropertiesSet method has done");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("The bean has been destroy");
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
