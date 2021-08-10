package org.example1.tasks1_4.config;

import org.example1.tasks1_4.beans3.BeanD;
import org.example1.tasks1_4.beans3.BeanF;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan(basePackages = "org.example1.beans2"),
        @ComponentScan(basePackageClasses = {BeanD.class, BeanF.class})
})
public class AppConfig2 {
}
