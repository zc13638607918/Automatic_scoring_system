package com.zc.service;

import com.zc.pojo.Clazz;
import com.zc.pojo.Student;

import java.util.ArrayList;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(String name);
    Student queryStudent(String name);
    ArrayList<Student> queryAll();
    void autoGradeMarking();
    void updateTable(Clazz clazz);
}
