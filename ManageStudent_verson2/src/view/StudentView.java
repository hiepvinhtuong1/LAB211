/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Report;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentView {

    public StudentView() {
    }

    private final String[] optionForUser = {
        "Create",
        "Find and Sort",
        "Update and Delete",
        "Report",
        "Exit"
    };

    public String[] getOptionForUser() {
        return optionForUser;
    }

    public void showMenu() {
        System.out.println("===== Student Management System =====");
        for (int i = 0; i < optionForUser.length; i++) {
            System.out.println((i + 1) + ". " + optionForUser[i]);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.err.println(error);
    }

    public void showStudent(Student student) {
        System.out.println(student.toString());
    }

    public void showListOfStudent(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i).toString());
        }
    }

    public void showListOfCourseName(List<String> courseNameList) {
        for (int i = 0; i < courseNameList.size(); i++) {
            System.out.println((i + 1) + ". " + courseNameList.get(i));
        }
    }

    public void showListOfReport(List<Report> reportList) {
        for (Report report : reportList) {
            System.out.println(report.toString());
        }
    }
}
