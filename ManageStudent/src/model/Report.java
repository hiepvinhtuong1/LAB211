/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.Validation;

/**
 *
 * @author Admin
 */
public class Report {
    private String idStudent;
    private String studentName;
    private String courseName;
    private int totalCourse;

    public Report(String idStudent, String studentName, String courseName, int totalCourse) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIDStudent(String studentName) {
        this.idStudent = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-20s | %-20s | %4d", studentName, courseName, totalCourse);
    }
    
}
