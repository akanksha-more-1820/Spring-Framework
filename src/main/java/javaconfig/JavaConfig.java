package javaconfig;

import org.springframework.context.annotation.Bean;


public class JavaConfig {
    @Bean
    public Sugar getSugar(){
        Sugar sugar=new Sugar();
        return sugar;
    }
    @Bean(name = {"student1","temp"})
    public Student getStudent(){
        //creating new obj
        Student st=new Student(getSugar());
        return st;
    }


}
