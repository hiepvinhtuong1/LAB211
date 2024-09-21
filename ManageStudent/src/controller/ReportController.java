/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Report;

/**
 *
 * @author Admin
 */
public class ReportController {

    private final ArrayList<Report> listOfReport;

    public ReportController() {
        this.listOfReport = new ArrayList<>();
    }


    public ArrayList<Report> getListOfReport() {
        return listOfReport;
    }

    public void clearReport() {
        this.listOfReport.clear();
    }

    public Report getReportByIdStudentAndCourse(String idStudent, String course) {
        for (Report report : listOfReport) {
            if (report.getIdStudent().equals(idStudent) && report.getCourseName().equals(course)) {
                return report;
            }
        }
        return null;
    }

//    public void addReport(String idStudent,String studentName, String String course, int totalCourse) {
//        if (getReportByIdStudentAndCourse(idStudent, course) == null) {
//            listOfReport.add(new Report(idStudent, studentName,course, totalCourse));
//        }
//    }
    
    public void addReport(String idStudent, String studentName, String course, int totalCourse ) {
        listOfReport.add(new Report(idStudent, studentName, course, totalCourse));
    }
    
    
    public void updateReport(String idStudent, String course, int totalCourse) {
            Report reportToUpdate = getReportByIdStudentAndCourse(idStudent, course);
            reportToUpdate.setTotalCourse(totalCourse);
    }
    
    public void updateListReport(String idStudnet, String studentName) {
        for (Report report : listOfReport) {
            if (report.getIdStudent().equals(idStudnet)) {
                report.setStudentName(studentName);
            }
        }
    }

    public void printReport() {
        System.out.println("List of report: ");
        for (Report report : listOfReport) {
            System.out.format("%-25s | %-15s | %-15d \n",
                    report.getStudentName(),
                    report.getCourseName(),
                    report.getTotalCourse()
            );
        }
    }
}
