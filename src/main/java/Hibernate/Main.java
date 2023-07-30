package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);

//        Student student=new Student(109,"Akanksha More","Mahabaleshwar");
//        int r=studentDao.insert(student);
//        System.out.println(r);


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go){
            System.out.println("Press 1 for add new Student");
            System.out.println("Press 2 for display all Students");
            System.out.println("Press 3 for get detail of single Student");
            System.out.println("Press 4 for delete Student");
            System.out.println("Press 5 to update Student");
            System.out.println("Press 6 for exit");

            try {
                int input=Integer.parseInt(br.readLine());

                switch (input){
                    case 1:
                        System.out.println("enter student id: ");
                        int id=Integer.parseInt(br.readLine());

                        System.out.println("enter student name: ");
                        String uName=br.readLine();

                        System.out.println("enter student city: ");
                        String uCity=br.readLine();
                        int r=studentDao.insert(new Student(id,uName,uCity));
                        System.out.println(r+" Student added");
                        break;
                    case 2:
                        List<Student> allStudents=studentDao.getAllStudents();
                        for (Student s:allStudents){
                            System.out.println("id: "+s.getStudentId()+" Name: "+s.getStudentName()+" City: "+s.getStudentCity());
                            System.out.println("--------------------------------------------------------------------");

                        }
                        break;
                    case 3:
                        System.out.println("Enter student id");
                        int getId=Integer.parseInt(br.readLine());
                        Student s=studentDao.getStudent(getId);
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("id: "+s.getStudentId()+" Name: "+s.getStudentName()+" City: "+s.getStudentCity());
                        System.out.println("-----------------------------------------------------------------------------------");
                        break;
                    case 4:
                        System.out.println("Enter student id");
                        int deleteId=Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(deleteId);
                        System.out.println("Student deleted");
                        break;
                    case 5:
                        System.out.println("Enter student id to be updated");
                        int idUpdated=Integer.parseInt(br.readLine());
                        Student updatedStudent=updateStudentDetails(idUpdated,studentDao);
                        studentDao.updateStudent(idUpdated,updatedStudent);
                        System.out.println("updated details are");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("id: "+updatedStudent.getStudentId()+" Name: "+updatedStudent.getStudentName()+" City: "+updatedStudent.getStudentCity());
                        System.out.println("------------------------------------------------------------------------------------------------------");


                        break;
                    case 6:
                        go=false;
                        break;
                }




                }catch (Exception e){
                System.out.println("invalid input");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you for using my application");



    }

    private static Student updateStudentDetails(Integer studentId,StudentDao studentDao) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("press 1 to change student's name");
        Student studentOld=studentDao.getStudent(studentId);
        int choice=Integer.parseInt(br.readLine());
        if(choice==1){
            System.out.println("enter student's name");
            String name=br.readLine();
            studentOld.setStudentName(name);
        }
        else{
            studentOld.setStudentName(studentOld.getStudentName());
        }

        System.out.println("press 1 to change student's city");
        int choiceCity=Integer.parseInt(br.readLine());
        if(choiceCity==1){
            System.out.println("enter student's city");
            String city=br.readLine();
            studentOld.setStudentCity(city);
        }
        else{
            studentOld.setStudentCity(studentOld.getStudentCity());
        }

        return studentOld;

    }

}