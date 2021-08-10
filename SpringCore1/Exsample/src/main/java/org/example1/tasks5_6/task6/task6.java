package org.example1.tasks5_6.task6;

import org.example1.tasks5_6.otherBeans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class task6 {
    private OtherBeanA beanA;
    private OtherBeanB beanB;
    @Autowired
    private OtherBeanC beanC;

    @Autowired
    public task6(OtherBeanA beanA){
        this.beanA = beanA;
    }

    public OtherBeanB getBeanB() {
        return beanB;
    }

    @Autowired
    public void setBeanB(OtherBeanB beanB) {
        this.beanB = beanB;
    }
}
