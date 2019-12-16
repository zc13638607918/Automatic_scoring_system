package com.zc.DAO;

import com.zc.pojo.Student;

import java.util.ArrayList;

public interface StudentDAO {
    Student selectStudent(String name);
    ArrayList<Student> selectAll();
    int insertStudent(Student user);
    int updateStudent(String name, String column, String value);
    int deleteStudent(String name);
    int deleteAll();
}
