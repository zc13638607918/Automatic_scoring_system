package com.zc.pojo;

import com.zc.annotate.StudentTableInfo;

import java.util.ArrayList;
@StudentTableInfo(tableName = "clazz")
public class Clazz {
    private ArrayList<Student> students= new ArrayList<>();

    public Clazz() {
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
