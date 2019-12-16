package com.zc.DAO.impl;

import com.zc.DAO.StudentDAO;
import com.zc.DAO.StudentTable;
import com.zc.pojo.ScoreTable;
import com.zc.pojo.Student;
import com.zc.pojo.Subject;
import com.zc.util.JDBCUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    static private Logger logger = Logger.getLogger(StudentDAOImpl.class);
    static private StudentTable studentTable = new StudentTable();
    static private String tableName = studentTable.getTableName();

    @Override
    public Student selectStudent(String name) {
        String sql = "select * from " + studentTable.getTableName() + " where " + studentTable.getColumnsName("name") + "=?";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        Student student = new Student();
        try {
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setRanking(rs.getInt(studentTable.getColumnsName("ranking")));
                student.setName(rs.getString(studentTable.getColumnsName("name")));
                student.setClazz(rs.getString(studentTable.getColumnsName("clazz")));
                extract(rs, student, studentTable.getColumnsName("health"), 9);
                extract(rs, student, studentTable.getColumnsName("language"), 5);
                extract(rs, student, studentTable.getColumnsName("society"), 7);
                extract(rs, student, studentTable.getColumnsName("science"), 10);
                extract(rs, student, studentTable.getColumnsName("art"), 6);
                student.setTotalScore(rs.getDouble(studentTable.getColumnsName("totalScore")));
                student.setRank(rs.getString(studentTable.getColumnsName("rank")));
            }
            return student;
        } catch (SQLException e) {
            logger.error("SQL异常", e);
        } finally {
            JDBCUtil.closeAll(rs, ps, conn);
        }
        return student;
    }

    public void extract(ResultSet rs, Student student, String str, int n) throws SQLException {
        double[] score = new double[n];
        for (int i = 0; i < n; i++) {
            score[i] = rs.getDouble(str + (i+1));
        }
        student.getScoreTable().getSubject(str).setScore(score);
        student.getScoreTable().getSubject(str).setTotalScore(rs.getDouble(str + "_total"));
    }

    @Override
    public ArrayList<Student> selectAll() {
        String sql = "select * from " + studentTable.getTableName() + " order by ranking";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        ArrayList<Student> arr = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setRanking(rs.getInt(studentTable.getColumnsName("ranking")));
                student.setName(rs.getString(studentTable.getColumnsName("name")));
                student.setClazz(rs.getString(studentTable.getColumnsName("clazz")));
                extract(rs, student, studentTable.getColumnsName("health"), 9);
                extract(rs, student, studentTable.getColumnsName("language"), 5);
                extract(rs, student, studentTable.getColumnsName("society"), 7);
                extract(rs, student, studentTable.getColumnsName("science"), 10);
                extract(rs, student, studentTable.getColumnsName("art"), 6);
                student.setTotalScore(rs.getDouble(studentTable.getColumnsName("totalScore")));
                student.setRank(rs.getString(studentTable.getColumnsName("rank")));
                arr.add(student);
            }
            return arr;
        } catch (SQLException e) {
            logger.error("SQL异常",e);
        } finally {
            JDBCUtil.closeAll(rs, ps, conn);
        }
        return arr;
    }

    @Override
    public int insertStudent(Student s) {
        String sql = "insert into " + tableName + " values(?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        ScoreTable st= s.getScoreTable();
        Subject h =st.getHealth();
        Subject l = st.getLanguage();
        Subject so =st.getSociety();
        Subject si =st.getScience();
        Subject a=st.getArt();
        return JDBCUtil.executeDML(sql,s.getRanking(),s.getName(),s.getClazz(),
                h.getScore()[0],h.getScore()[1],h.getScore()[2],h.getScore()[3],h.getScore()[4],h.getScore()[5],
                h.getScore()[6],h.getScore()[7],h.getScore()[8],h.getTotalScore(),
                l.getScore()[0],l.getScore()[1],l.getScore()[2],
                l.getScore()[3],l.getScore()[4],l.getTotalScore(),
                so.getScore()[0],so.getScore()[1],so.getScore()[2],so.getScore()[3],
                so.getScore()[4], so.getScore()[5],so.getScore()[6],so.getTotalScore(),
                si.getScore()[0],si.getScore()[1],si.getScore()[2],si.getScore()[3],
                si.getScore()[4],si.getScore()[5],si.getScore()[6],si.getScore()[7],
                si.getScore()[8],si.getScore()[9],si.getTotalScore(),
                a.getScore()[0],a.getScore()[1],a.getScore()[2],a.getScore()[3],
                a.getScore()[4],a.getScore()[5],a.getTotalScore(),
                s.getTotalScore(),s.getRank());
    }

    @Override
    public int updateStudent(String name, String column, String value) {
        String sql = "update " + tableName + " set " + column + "=? where " + studentTable.getColumnsName("name") + "=?";
        return JDBCUtil.executeDML(sql, value, name);
    }

    @Override
    public int deleteStudent(String name) {
        String sql = "delete from " + tableName + " where " + studentTable.getColumnsName("name") + "=?";
        return JDBCUtil.executeDML(sql, name);
    }

    @Override
    public int deleteAll() {
        String sql = "delete from "+ tableName;
        return JDBCUtil.executeDML(sql);
    }
}
