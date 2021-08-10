package org.example1.tasks1_4.config;

import org.example1.tasks1_4.beans1.*;
import org.example1.tasks1_4.beans2.*;
import org.example1.tasks1_4.beans3.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

//, "org.example1.beans2"
@Configuration
@ComponentScan(value = "org/example1/beans1.BeanA")
public class test1 {
}
