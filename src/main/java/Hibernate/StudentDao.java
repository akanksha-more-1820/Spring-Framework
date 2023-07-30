package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentDao {

    private HibernateTemplate hibernateTemplate;
    //save student
    public int insert(Student student){

        int res= (int) this.hibernateTemplate.save(student);
        return 1;
    }

    public Student getStudent(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        return student;
    }

    public List<Student> getAllStudents(){
        List<Student> student=this.hibernateTemplate.loadAll(Student.class);
        return student;
    }

    public void deleteStudent(int studentId){
       Student student= this.hibernateTemplate.get(Student.class,studentId);
       this.hibernateTemplate.delete(student);
    }

    public void updateStudent(int studentId,Student student){

        this.hibernateTemplate.update(student);
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
