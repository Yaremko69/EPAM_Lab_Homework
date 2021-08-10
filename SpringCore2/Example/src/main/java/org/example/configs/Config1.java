package org.example.configs;


import org.example.beans.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Configuration
@Import(Config2.class)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = {MyBeanFactoryPostProcessor.class, MyBeanPostProcessor.class})
public class Config1 {


    @Bean
    @Qualifier("beanA")
    public BeanA getBeanA(){
        return new BeanA(null, 1);
    }

    @Bean
    @Qualifier("beanB")
    @Description("beanD")
    public BeanB getBeanB(@Value("${beanB.name}") String name, @Value("${beanB.value}")int value){
        return new BeanB(name, value);
    }

    @Bean
    @Qualifier("beanC")
    @Description("beanB")
    public BeanC getBeanC(@Value("${beanC.name}") String name, @Value("${beanC.value}")int value){
        return new BeanC(name, value);
    }

    @Bean
    @Qualifier("beanD")
    public BeanD getBeanD(@Value("${beanD.name}") String name, @Value("${beanD.value}")int value){
        return new BeanD(name, value);
    }

    @Bean
    @Qualifier("beanE")
    public BeanE getBeanE(){
        return new BeanE("beanE", -5);
    }

    @Bean
    @Lazy
    @Qualifier("beanF")
    public BeanF getBeanF(){
        return new BeanF(null, -6);
    }


}
