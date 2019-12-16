package com.zc.DAO;

import com.zc.annotate.Columns;
import com.zc.annotate.StudentTableInfo;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class StudentTable {
    private String tableName;
    private Map<String, String> columnsName = new HashMap<>();
    private static Logger logger = Logger.getLogger(StudentTable.class);

    public String getTableName() {
        return tableName;
    }

    public String getColumnsName(String str) {
        return columnsName.get(str);
    }

    public StudentTable() {
        Class clazz1 = null;
        Class clazz2 = null;
        Class clazz3=null;
        try {

            clazz1 = Class.forName("com.zc.pojo.Student");
            clazz2 = Class.forName("com.zc.pojo.ScoreTable");
            clazz3 =Class.forName("com.zc.pojo.Clazz");
            StudentTableInfo studentTableInfo = (StudentTableInfo) clazz3.getAnnotation(StudentTableInfo.class);
            tableName = studentTableInfo.tableName();

            Field[] fields1 = clazz1.getDeclaredFields();
            for (Field f : fields1) {
                if(f.getAnnotation(Columns.class)==null)continue;
                Columns studentColumns = f.getAnnotation(Columns.class);
                columnsName.put(f.getName(), studentColumns.columnName());
            }
            Field[] fields2 = clazz2.getDeclaredFields();
            for (Field f : fields2) {
                if(f.getAnnotation(Columns.class)==null)continue;
                Columns studentColumns = f.getAnnotation(Columns.class);
                columnsName.put(f.getName(), studentColumns.columnName());
            }
        } catch (ClassNotFoundException e) {
            logger.error("未找到cLass异常" + e);
        }
    }
}
