package com.akanksha.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("stereoconfig.xml");
        Student st= context.getBean("student", Student.class);
        System.out.println(st.hashCode());
        Student s2=context.getBean("student", Student.class);
        System.out.println(s2.hashCode());
    }
}
