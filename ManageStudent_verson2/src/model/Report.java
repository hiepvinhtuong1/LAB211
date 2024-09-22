/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Report {

    private String studentId;
    private String studentName;
    private String courseName;
    private int courseTotal;

    public Report(String studentId, String studentName, String courseName, int courseTotal) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseTotal = courseTotal;
    }
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String id) {
        this.studentId = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTotal() {
        return courseTotal;
    }

    public void setCourseTotal(int courseTotal) {
        this.courseTotal = courseTotal;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-20s | %-20s | %-4d", studentName, courseName, courseTotal);
    }
}
