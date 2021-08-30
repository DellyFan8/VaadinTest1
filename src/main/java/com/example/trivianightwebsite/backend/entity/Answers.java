package com.example.trivianightwebsite.backend.entity;

public class Answers {

    //Q is the answer, S is correct or incorrect
    private int id;
    private String Q1;
    private boolean S1;
    private String Q2;
    private boolean S2;
    private String Q3;
    private boolean S3;
    private String Q4;
    private boolean S4;
    private String Q5;
    private boolean S5;
    private String Q6;
    private boolean S6;
    private String Q7;
    private boolean S7;
    private String Q8;
    private boolean S8;
    private String Q9;
    private boolean S9;
    private String Q10;
    private boolean S10;
    private String Q11;
    private boolean S11;
    private String Q12;
    private boolean S12;
    private int score;
    private String team_name;
    private String round;

    public Answers(){

    }

    public Answers(int id, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8, String q9, String q10, String q11, String q12, String name, String Round) {
        Q1 = q1;
        Q2 = q2;
        Q3 = q3;
        Q4 = q4;
        Q5 = q5;
        Q6 = q6;
        Q7 = q7;
        Q8 = q8;
        Q9 = q9;
        Q10 = q10;
        Q11 = q11;
        Q12 = q12;
        team_name = name;
        round = Round;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQ1() {
        return Q1;
    }

    public void setQ1(String q1) {
        Q1 = q1;
    }

    public String getQ2() {
        return Q2;
    }

    public void setQ2(String q2) {
        Q2 = q2;
    }

    public String getQ3() {
        return Q3;
    }

    public void setQ3(String q3) {
        Q3 = q3;
    }

    public String getQ4() {
        return Q4;
    }

    public void setQ4(String q4) {
        Q4 = q4;
    }

    public String getQ5() {
        return Q5;
    }

    public void setQ5(String q5) {
        Q5 = q5;
    }

    public String getQ6() {
        return Q6;
    }

    public void setQ6(String q6) {
        Q6 = q6;
    }

    public String getQ7() {
        return Q7;
    }

    public void setQ7(String q7) {
        Q7 = q7;
    }

    public String getQ8() {
        return Q8;
    }

    public void setQ8(String q8) {
        Q8 = q8;
    }

    public String getQ9() {
        return Q9;
    }

    public void setQ9(String q9) {
        Q9 = q9;
    }

    public String getQ10() {
        return Q10;
    }

    public void setQ10(String q10) {
        Q10 = q10;
    }

    public String getQ11() {
        return Q11;
    }

    public void setQ11(String q11) {
        Q11 = q11;
    }

    public String getQ12() {
        return Q12;
    }

    public void setQ12(String q12) {
        Q12 = q12;
    }

    public boolean isS1() {
        return S1;
    }

    public void setS1(boolean s1) {
        S1 = s1;
    }

    public boolean isS2() {
        return S2;
    }

    public void setS2(boolean s2) {
        S2 = s2;
    }

    public boolean isS3() {
        return S3;
    }

    public void setS3(boolean s3) {
        S3 = s3;
    }

    public boolean isS4() {
        return S4;
    }

    public void setS4(boolean s4) {
        S4 = s4;
    }

    public boolean isS5() {
        return S5;
    }

    public void setS5(boolean s5) {
        S5 = s5;
    }

    public boolean isS6() {
        return S6;
    }

    public void setS6(boolean s6) {
        S6 = s6;
    }

    public boolean isS7() {
        return S7;
    }

    public void setS7(boolean s7) {
        S7 = s7;
    }

    public boolean isS8() {
        return S8;
    }

    public void setS8(boolean s8) {
        S8 = s8;
    }

    public boolean isS9() {
        return S9;
    }

    public void setS9(boolean s9) {
        S9 = s9;
    }

    public boolean isS10() {
        return S10;
    }

    public void setS10(boolean s10) {
        S10 = s10;
    }

    public boolean isS11() {
        return S11;
    }

    public void setS11(boolean s11) {
        S11 = s11;
    }

    public boolean isS12() {
        return S12;
    }

    public void setS12(boolean s12) {
        S12 = s12;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", Q1='" + Q1 + '\'' +
                ", S1=" + S1 +
                ", Q2='" + Q2 + '\'' +
                ", S2=" + S2 +
                ", Q3='" + Q3 + '\'' +
                ", S3=" + S3 +
                ", Q4='" + Q4 + '\'' +
                ", S4=" + S4 +
                ", Q5='" + Q5 + '\'' +
                ", S5=" + S5 +
                ", Q6='" + Q6 + '\'' +
                ", S6=" + S6 +
                ", Q7='" + Q7 + '\'' +
                ", S7=" + S7 +
                ", Q8='" + Q8 + '\'' +
                ", S8=" + S8 +
                ", Q9='" + Q9 + '\'' +
                ", S9=" + S9 +
                ", Q10='" + Q10 + '\'' +
                ", S10=" + S10 +
                ", Q11='" + Q11 + '\'' +
                ", S11=" + S11 +
                ", Q12='" + Q12 + '\'' +
                ", S12=" + S12 +
                ", score=" + score +
                ", team_name='" + team_name + '\'' +
                ", round='" + round + '\'' +
                '}';
    }
}
