package com.zc.Test;

import com.zc.pojo.Clazz;
import com.zc.pojo.Student;
import com.zc.service.StudentService;
import com.zc.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        Clazz clazz =new Clazz();
        ArrayList<Student> arr=clazz.getStudents();
        arr.add( new Student("李贝柠",1,null,null));
        arr.add( new Student("原诗涵",2,"社会","艺术"));
        arr.add( new Student("李昱泽",3,null,"社会"));
        arr.add( new Student("杨道辰",4,null,null));
        arr.add( new Student("余欣舒",5,null,null));
        arr.add( new Student("李子牧",6,null,"社会"));
        arr.add( new Student("严立安",7,null,null));
        arr.add( new Student("杜知远",8,null,null));
        arr.add( new Student("江劲辰",9,null,null));
        arr.add( new Student("谢涵颖",10,"语言",null));
        arr.add( new Student("揭鈜博",11,"语言",null));
        arr.add( new Student("张俊杰",12,"健康",null));
        arr.add( new Student("王星贝",13,"艺术",null));
        arr.add( new Student("余海慧",14,null,null));
        arr.add( new Student("刘芷希",15,"艺术",null));
        arr.add( new Student("刘锐凡",16,"健康",null));
        arr.add( new Student("李欣然",17,"艺术","社会"));
        arr.add( new Student("周一诺",18,null,null));
        arr.add( new Student("刘沐阳",19,"艺术","健康"));
        arr.add( new Student("吴思睿",20,"艺术","社会"));
        arr.add( new Student("邹智屹",21,"语言",null));
        arr.add( new Student("贺思淼",22,"艺术",null));
        arr.add( new Student("余炆晓",23,null,null));
        arr.add( new Student("张梓霁",24,null,"科学"));
        arr.add( new Student("刘沛",25,null,null));
        arr.add( new Student("王雨泽",26,null,"艺术"));
        arr.add( new Student("邓同玉",27,null,null));
        arr.add( new Student("方佳琪",28,null,null));
        arr.add( new Student("陈冠憬",29,null,null));
        arr.add( new Student("邵俊霖",30,null,null));
        arr.add( new Student("缪妙果",31,"健康",null));
        arr.add( new Student("袁若芸",32,"艺术",null));
        arr.add( new Student("陈一菲",33,null,"科学"));
        arr.add( new Student("林子琛",34,null,"艺术"));
        studentService.updateTable(clazz);

    }
}
