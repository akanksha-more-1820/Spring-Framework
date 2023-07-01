package com.akanksha.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("lifeconfig.xml");
//         Samosa samosa= (Samosa) context.getBean("s1");
//        System.out.println(samosa);
        context.registerShutdownHook();
//        System.out.println("--------------------------------------------------------------");
//        Pepsi pepsi= (Pepsi) context.getBean("pepsi");
//        System.out.println(pepsi.getPrice());

         Example example= (Example) context.getBean("example");
        System.out.println(example);



    }
}
