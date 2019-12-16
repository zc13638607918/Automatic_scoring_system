package com.zc.pojo;

import java.util.Arrays;

public class Subject {
    private int n;
    private String name;
    private double[] SCORE;
    double[] score;
    private double totalScore;

    public Subject(String name, double[] SCORE) {
        this.name = name;
        this.SCORE = SCORE;
        this.n=SCORE.length;
        this.score =new double[n];
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getSCORE() {
        return SCORE;
    }

    public void setSCORE(double[] SCORE) {
        this.SCORE = SCORE;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "{"+ Arrays.toString(score) +
                ","+name+"_totalScore=" + totalScore +
                '}';
    }
}
