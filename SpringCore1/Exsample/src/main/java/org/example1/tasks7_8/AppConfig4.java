package org.example1.tasks7_8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example1.tasks7_8.animals")
@ComponentScan(basePackageClasses = Zoo.class)
public class AppConfig4 {
}
