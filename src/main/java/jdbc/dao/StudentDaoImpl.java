package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {//insert query
        String query="insert into student(id,name,city) values(?,?,?)";

        //fire query
        int result=jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());


        return result;
    }

    @Override
    public int change(Student student) {
        //updating data
        String query="update student set name=?, city=? where id=?";

        int result=jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return result;
    }

    @Override
    public int delete(int studentId) {
        //delete
        String query="delete from student where id=?";
        int res=this.jdbcTemplate.update(query,studentId);
        return  res;
    }

    @Override
    public Student getStudent(int studentId) {
        //selecting single student
        RowMapper<Student> rowMapper=new RowMapperImpl();
        String query="select * from student where id=?";
        Student student=this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return student ;
    }

    @Override
    public List<Student> getAllStudents() {
        //selecting multiple student
        String query="select * from student";
        List<Student> studentList=this.jdbcTemplate.query(query,new RowMapperImpl());
        return studentList;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
