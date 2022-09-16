package com.company.entity;

public class Student {
    private String StudentName;
    private boolean StudentSex;
    private String StudentId;

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Boolean getStudentSex() {
        return StudentSex;
    }

    public void setStudentSex(Boolean studentSex) {
        StudentSex = studentSex;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public Student(String studentName, Boolean studentSex, String studentId) {
        StudentName = studentName;
        StudentSex = studentSex;
        StudentId = studentId;
    }

    public Student() {
    }
}
