package com.spring.jdbc;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println( "Program Started" );
//        System.out.println("enter a student Id to delete");
//        Scanner sc=new Scanner(System.in);
//        int id=sc.nextInt();

        //using spring jdbc

        ApplicationContext context=new
                ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao= context.getBean("studentDao", StudentDao.class);

        //select multiple student
        List<Student> studentList=studentDao.getAllStudents();
        for (Student s :studentList){
            System.out.println(s);

        }


        //select single student

//        Student student=studentDao.getStudent(459);
//        System.out.println(student);


        //deleting
//        int res=studentDao.delete(id);
//        System.out.println("Deleted students are:-"+res);

        //updating data
//        Student student=new Student();
//        student.setId(102);
//        student.setName("Dinkar Roa More");
//        student.setCity("Ahmednagar");
//        int res=studentDao.change(student);
//        System.out.println("student updated are:-" +res);

// inserting
//        Student student=new Student();
//        student.setId(102);
//        student.setName("Dinkar More");
//        student.setCity("Hyderabad");
//
//        int result=studentDao.insert(student);
//        System.out.println(result+" records inserted ");
//        JdbcTemplate template=context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        //insert query
//        String query="insert into student(id,name,city) values(?,?,?)";
//
//        //fire query
//        int result=template.update(query,459,"Vidya More","Shivaji Nagar");
//        System.out.println(result+" records inserted ");
    }
}