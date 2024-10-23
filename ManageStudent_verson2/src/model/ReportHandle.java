/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ReportHandle {

    private final List<Report> reportList = new ArrayList<>();

    public ReportHandle() {
    }

    public List<Report> getAllReports() {
        return new ArrayList<>(reportList);
    }

    public List<Report> getListReportByStudentId(String studentId) {
        List<Report> listReportById = new ArrayList<>();
        for (Report report : reportList) {
            if (report.getStudentId().equals(studentId)) {
                listReportById.add(report);
            }
        }
        return listReportById;
    }

    public Report getReportByStudentIdAndCourseName(String studentId, String courseName) {
        for (Report report : reportList) {
            if (report.getStudentId().equals(studentId) && report.getCourseName().equals(courseName)) {
                return report;
            }
        }
        return null;
    }

    public void addReport(Report report) {
        reportList.add(report);
    }

    public void updateStudentName(String studentId, String studentName) {
        List<Report> listReportById = getListReportByStudentId(studentId);
        for (Report report : listReportById) {
            report.setStudentName(studentName);
        }
    }

    public void deleteReport(Report report) {
        reportList.remove(report);
    }

    public void increseaCourse(Report report) {
        System.out.println("New report: " + report.getCourseName());
        report.setCourseTotal(report.getCourseTotal() + 1);
    }

    public void decreaseCourse(Report report) {
        System.out.println("Old report: " + report.getCourseName());
        report.setCourseTotal(report.getCourseTotal() - 1);
    }
}
