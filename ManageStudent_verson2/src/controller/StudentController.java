/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Report;
import model.Student;
import utils.StudentRule;
import utils.Validation;
import view.StudentView;
import model.StudentHandle;
import model.ReportHandle;

/**
 *
 * @author Admin
 */
public class StudentController {

    private final Validation validation;
    private final StudentView studentView;
    private final StudentRule studentRule;
    private final StudentHandle studentHandle;
    private final ReportHandle reportHandle;

    public StudentController(Validation validation, StudentView studentView, StudentRule studentRule, ReportHandle reportHandle, StudentHandle studentHandle) {
        this.validation = validation;
        this.studentView = studentView;
        this.studentRule = studentRule;
        this.reportHandle = reportHandle;
        this.studentHandle = studentHandle;
    }

    public void run() {
        while (true) {
            studentView.showMenu();
            int choice = validation.getInt("Enter your choice: ", 1, studentView.getOptionForUser().length);
            switch (choice) {
                case 1:

                    createListStudent();
                    break;
                case 2:

                    findAndSortStudents();
                    break;
                case 3:

                    updateAndDelete();
                    break;
                case 4:

                    report();
                    break;
                case 5:
                    studentView.showMessage("Exit succesfully");
                    return; // Exit the program
            }
        }
    }

    /**
     * Function: Create a single student
     */
    public void createStudent() {
        String id, studentName, semester, courseName;
        try {

            //Get and validate user input for student details
            id = validation.validateId("Enter id: ", studentRule.getIdRule());
            studentName = validation.validateStudentName("Enter student name: ", 1);
            semester = validation.validateSemester("Enter semester: ", studentRule.getSemesterRule(), 1);
            courseName = validation.validateCourseName("Enter course name: ", studentRule.getCourseNameOption(), 1);

            // Create a new object student
            Student newStudent = new Student(id, studentName, semester, courseName);
            
            // Check if student can be added
            if (studentHandle.checkValidStudentCreate(newStudent, studentRule)) {
                
                // add the student
                studentHandle.addStudent(newStudent);
                
                // handle report for student
                Report report = reportHandle.getReportByStudentIdAndCourseName(newStudent.getId(), newStudent.getCourseName());
                if (report == null) {
                    reportHandle.addReport(new Report(newStudent.getId(), newStudent.getStudentName(), newStudent.getCourseName(), 1));
                } else {
                    reportHandle.increseaCourse(report);
                }
                System.out.println("-----Create sucessfully-----");
            }
        } catch (Exception e) {
            
            //show any errors for user
            studentView.showError(e.getMessage());
        }
    }

    public void createListStudent() {
        studentView.showMessage("--------- CREATE ----------");
        while (true) {
            createStudent();
            while (studentHandle.getAllStudents().size() >= 1) {
                System.out.println("Do you want to continue (Y/N)?");

                /**
                 * function: return choice of user: User choose Y to continue
                 * User choose N to stop
                 */
                boolean choice = validation.validateConfirm(
                        "Do you want to continue (Y/N)?",
                        "Please enter Y or N",
                        "Y",
                        "N"
                );
                if (choice) {
                    createStudent();
                } else {
                    break;
                }
            }
            if (studentHandle.getAllStudents().size() >= 1) {
                break;
            }
        }
    }

    /**
     * function: ask user want to update or delete. if update call updatestudent
     */
    public void updateAndDelete() {
        studentView.showMessage("--------- UPDATE AND DELETE ----------");
        String id = validation.validateId(
                "Enter id: ",
                studentRule.getIdRule()
        );
        if (studentHandle.getStudentById(id) == null) {
            studentView.showError("Id of student does not exist in list");
            return;
        }
        studentView.showMessage("Do you want to update(U) or delete(D) student: ");

        /**
         * function: return choice of user: User choose U return true User
         * choose D return false
         */
        boolean choiceOfUser = validation.validateConfirm(
                "Do you want to update(U) or delete(D) student: \"",
                "Please enter U or D",
                "U",
                "D"
        );
        List<Student> listStudentById = studentHandle.getListStudentById(id);
        studentView.showMessage("List of Student By ID: ");
        studentView.showListOfStudent(listStudentById);
        if (choiceOfUser) {
            try {
                int indexUpdateStudent = validation.getInt(
                        "Enter index of student whom you want to update: ",
                        1,
                        listStudentById.size()
                );
                Student studentToUpdate = listStudentById.get(indexUpdateStudent - 1);
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
                }

                Report oldReport = reportHandle.getReportByStudentIdAndCourseName(studentToUpdate.getId(), studentToUpdate.getCourseName());
                Report newReport = reportHandle.getReportByStudentIdAndCourseName(newStudent.getId(), newCourseName);
                if (newReport == null) {
                    reportHandle.addReport(new Report(newStudent.getId(), newStudent.getStudentName(), newStudent.getCourseName(), 1));
                } else {
                    reportHandle.increseaCourse(newReport);
                }
                reportHandle.decreaseCourse(oldReport);
                if (oldReport.getCourseTotal() == 0) {
                    reportHandle.deleteReport(oldReport);
                }

                studentHandle.updateStudent(studentToUpdate, newStudent);
                studentView.showMessage("Update succesfully");

            } catch (Exception ex) {
                studentView.showError(ex.getMessage());
            }
        } else {
            int indexUpdateStudent = validation.getInt(
                    "Enter index of student whom you want to delete: ",
                    1,
                    listStudentById.size()
            );
            Student studentToDelete = listStudentById.get(indexUpdateStudent - 1);
            Report oldReport = reportHandle.getReportByStudentIdAndCourseName(studentToDelete.getId(), studentToDelete.getCourseName());
            reportHandle.decreaseCourse(oldReport);
            if (oldReport.getCourseTotal() == 0) {
                reportHandle.deleteReport(oldReport);
            }
            if (studentHandle.deleteStudent(listStudentById.get(indexUpdateStudent - 1))) {
                studentView.showMessage("Delete succesfully!");
            } else {
                studentView.showMessage("Delete failure!");
            }
        }
    }

    /**
     *
     */
    public void findAndSortStudents() {
        studentView.showMessage("--------- FIND AND SORT ----------");
        String name = validation.validateStudentName("Enter student name: ", 1);
        List<Student> listStudentByName = studentHandle.getStudentByName(name);
        listStudentByName.sort((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName()));
        studentView.showListOfStudent(listStudentByName);
    }

    public void report() {
        studentView.showMessage("--------- REPORT ----------");
        List<Report> reports = reportHandle.getAllReports();
        studentView.showListOfReport(reports);
    }
}
