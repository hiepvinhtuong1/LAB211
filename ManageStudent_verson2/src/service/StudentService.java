/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Report;
import model.ReportHandle;
import model.Student;
import model.StudentHandle;
import utils.Validation;

/**
 *
 * @author Admin
 */
public class StudentService {

    private final StudentHandle studentHandle;
    private final Validation validation;
    private final StudentRule studentRule;
    private final ReportHandle reportHandle;

    public StudentService(StudentHandle studentHandle, Validation validation, StudentRule studentRule, ReportHandle reportHandle) {
        this.studentHandle = studentHandle;
        this.validation = validation;
        this.studentRule = studentRule;
        this.reportHandle = reportHandle;
    }

    public boolean isEmpty() {
        return studentHandle.getAllStudents().isEmpty();
    }

    public int length() {
        return studentHandle.getAllStudents().size();
    }

    public Student getStudentById(String id) {
        return studentHandle.getStudentById(id);
    }

    public List<Student> getListStudentById(String id) {
        return studentHandle.getListStudentById(id);
    }

    /**
     * function: create a new student
     *
     * @param newStudent
     * @return
     * @throws java.lang.Exception
     */
    public boolean create(Student newStudent) throws Exception {
        if (studentHandle.checkValidStudentCreate(newStudent, studentRule)) {
            studentHandle.addStudent(newStudent);
            Report report = reportHandle.getReportByStudentIdAndCourseName(newStudent.getId(), newStudent.getCourseName());
            if (report == null){
                reportHandle.addReport(new Report(newStudent.getId(), newStudent.getStudentName(), newStudent.getCourseName(), 1));
            } else {
                reportHandle.increseaCourse(report);
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @param studentToUpdate: student who need to update information
     * @return : if update succesfully return true, else return false
     * @throws java.lang.Exception
     */
    public boolean updateSutdent(Student studentToUpdate) throws Exception {

        String newStudentName, newSemester, newCourseName;
        newStudentName = validation.validateStudentName("Enter name to update: ", 2);
        if (newStudentName.isEmpty()) {
            newStudentName = studentToUpdate.getStudentName();
        }

        newSemester = validation.validateSemester("Enter semester to update: ", studentRule.getSemesterRule(), 2);
        if (newSemester.isEmpty()) {
            newSemester = studentToUpdate.getSemester();
        }

        newCourseName = validation.validateCourseName("Enter course name to update: ", studentRule.getCourseNameOption(), 2);
        if (newCourseName.isEmpty()) {
            newCourseName = studentToUpdate.getCourseName();
        }

        Student newStudent = new Student(studentToUpdate.getId(), newStudentName, newSemester, newCourseName);
        studentHandle.checkValidStudentUpdate(newStudent, studentRule);
        if (!newStudent.getStudentName().equals(studentToUpdate.getStudentName())) {
            studentHandle.updateStudentName(newStudent.getId(), newStudentName);
            reportHandle.updateStudentName(newStudentName, newStudentName);
            Report oldReport = reportHandle.getReportByStudentIdAndCourseName(studentToUpdate.getId(), studentToUpdate.getCourseName());
            Report newReport = reportHandle.getReportByStudentIdAndCourseName(newStudentName, newCourseName);
            reportHandle.increseaCourse(newReport);
            reportHandle.decreaseCourse(oldReport);
        }
        studentHandle.updateStudent(newStudent);
        return true;
    }

    /**
     *
     * @param studentToDelete:student who need to delete
     * @return : return true if can delete, return false if can not delete
     */
    public boolean deleteStudent(Student studentToDelete) {
        Report report = reportHandle.getReportByStudentIdAndCourseName(studentToDelete.getId(), studentToDelete.getCourseName());
        reportHandle.decreaseCourse(report);
        return studentHandle.deleteStudent(studentToDelete);
    }
    
    public List<Student> getStudentByName(String studentNameToFind){
        return studentHandle.getStudentByName(studentNameToFind);
    }
}
