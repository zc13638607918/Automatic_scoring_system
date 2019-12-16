package com.zc.pojo;

import com.zc.annotate.Columns;
import com.zc.annotate.StudentTableInfo;

@StudentTableInfo(tableName = "clazz")
public class ScoreTable {
    Subject[] subjects;
    @Columns(columnName = "health")
    Subject health;
    @Columns(columnName = "language")
    Subject language;
    @Columns(columnName = "society")
    Subject society;
    @Columns(columnName = "science")
    Subject science;
    @Columns(columnName = "art")
    Subject art;

    public ScoreTable() {

        this.health =new Subject("health", new double[]{6, 3, 2, 3, 2, 2, 3, 3, 3});
        this.language =new Subject("language", new double[]{3, 3, 3, 3, 2});
        this.society =new Subject("society", new double[]{2, 3, 2, 3, 2, 3, 3});
        this.science =new Subject("science", new double[]{2, 2, 2, 2, 3, 2,2, 3, 3,2});
        this.art =new Subject("art", new double[]{3, 3, 3, 3, 3, 3});

        this.subjects =new Subject[5];
        subjects[0]=health;
        subjects[1]=language;
        subjects[2]=society;
        subjects[3]=science;
        subjects[4]=art;
    }

    @Override
    public String toString() {
        return "{" +
                "health=" + health +
                ", language=" + language +
                ", society=" + society +
                ", science=" + science +
                ", art=" + art +
                '}';
    }

    public Subject getSubject(String subName){
        Subject subject=null;
        switch (subName){
            case "health":
                subject=getHealth();
                break;
            case "language":
                subject=getLanguage();
                break;
            case "society":
                subject=getSociety();
                break;
            case "science":
                subject=getScience();
                break;
            case "art":
                subject=getArt();
                break;
        }
        return subject;
    }

    public Subject getHealth() {
        return health;
    }

    public void setHealth(double[] score) {
        this.health.setScore(score);
    }

    public Subject getLanguage() {
        return language;
    }

    public void setLanguage(double[] score) {
        this.language.setScore(score);
    }

    public Subject getSociety() {
        return society;
    }

    public void setSociety(double[] score) {
        this.society.setScore(score);
    }

    public Subject getScience() {
        return science;
    }

    public void setScience(double[] score) {
        this.science.setScore(score);
    }

    public Subject getArt() {
        return art;
    }

    public void setArt(double[] score) {
        this.art.setScore(score);
    }

}
