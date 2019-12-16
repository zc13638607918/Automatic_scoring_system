package com.zc.service.impl;

import com.zc.DAO.StudentDAO;
import com.zc.DAO.impl.StudentDAOImpl;
import com.zc.pojo.Clazz;
import com.zc.pojo.Student;
import com.zc.service.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
static StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public void addStudent(Student student) {
        studentDAO.insertStudent(student);
    }

    @Override
    public void deleteStudent(String name) {

        studentDAO.deleteStudent(name);
    }

    @Override
    public Student queryStudent(String name) {

        return studentDAO.selectStudent(name);
    }

    @Override
    public ArrayList<Student> queryAll() {

        return studentDAO.selectAll();
    }

    @Override
    public void autoGradeMarking() {

    }

    @Override
    public void updateTable(Clazz clazz) {
        studentDAO.deleteAll();
        for (Student s:clazz.getStudents()
             ) {
            studentDAO.insertStudent(s);
        }
    }
}
