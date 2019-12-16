package com.zc.pojo;

import com.zc.annotate.Columns;

public class Student {
    @Columns(columnName = "ranking")
    private int ranking;
    @Columns(columnName = "name")
    private String name;
    @Columns(columnName = "clazzname")
    private String clazz;
    ScoreTable scoreTable;
    @Columns(columnName = "total")
    private double totalScore;
    @Columns(columnName = "rank")
    private String rank;
    private String strong;
    private String week;

    public Student(String name, int ranking, String strong, String week) {
        this.ranking = ranking;
        this.name = name;
        this.clazz = "中二班";
        this.strong = strong;
        this.week = week;
        this.scoreTable=new ScoreTable();
    }

    public Student() {
        this.clazz = "中二班";
        this.scoreTable=new ScoreTable();
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }

    public void setScoreTable(ScoreTable scoreTable) {
        this.scoreTable = scoreTable;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                scoreTable +
                ", totalScore=" + totalScore +
                ", rank='" + rank + '\'' +
                '}';
    }
}
