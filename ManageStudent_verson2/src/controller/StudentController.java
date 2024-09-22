/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Student;
import service.StudentRule;
import service.StudentService;
import utils.Validation;
import view.StudentView;
import service.ReportService;
/**
 *
 * @author Admin
 */
public class StudentController {

    private final StudentService studentService;
    private final Validation validation;
    private final StudentView studentView;
    private final StudentRule studentRule;
    private final ReportService reportService;

    public StudentController(StudentService studentService, Validation validation, StudentView studentView, StudentRule studentRule, ReportService reportSerivce) {
        this.studentService = studentService;
        this.validation = validation;
        this.studentView = studentView;
        this.studentRule = studentRule;
        this.reportService = reportSerivce;
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

    public void createStudent() {
        String id, studentName, semester, courseName;
        while (true) {
            try {
                id = validation.validateId("Enter id: ", studentRule.getIdRule());
                studentName = validation.validateStudentName("Enter student name: ", 1);
                semester = validation.validateSemester("Enter semester: ", studentRule.getSemesterRule(), 1);
                courseName = validation.validateCourseName("Enter course name: ", studentRule.getCourseNameOption(), 1);
                Student newStudent = new Student(id, studentName, semester, courseName);
                if (studentService.create(newStudent)) {
                    studentView.showMessage("-----Create student succesfully-----");
                }
            } catch (Exception e) {
                studentView.showError(e.getMessage());
            }
        }
    }

    public void createListStudent() {
        studentView.showMessage("--------- CREATE ----------");
        if (studentService.isEmpty()) {
            while (true) {
                createStudent();
                if (studentService.length() >= 5) {
                    System.out.println("Do you want to continue (Y/N)?");

                    /**
                     * function: return choice of user: User choose Y to
                     * continue User choose N to stop
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
        if (studentService.getStudentById(id) == null) {
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

        List<Student> listStudentById = studentService.getListStudentById(id);
        studentView.showMessage("List of Student By ID: ");
        studentView.showListOfStudent(listStudentById);
        if (choiceOfUser) {
            try {
                int indexUpdateStudent = validation.getInt(
                        "Enter index of student whom you want to update: ",
                        1,
                        listStudentById.size()
                );
                if (studentService.updateSutdent(listStudentById.get(indexUpdateStudent - 1))) {
                    studentView.showMessage("Update succesfully");
                }

            } catch (Exception ex) {
                studentView.showError(ex.getMessage());
            }
        } else {
            int indexUpdateStudent = validation.getInt(
                    "Enter index of student whom you want to delete: ",
                    1,
                    listStudentById.size()
            );
            if (studentService.deleteStudent(listStudentById.get(indexUpdateStudent - 1))) {
                studentView.showMessage("Delete succesfully!");
            } else {
                studentView.showMessage("Delete failure!");
            }
        }
    }

    public void findAndSortStudents() {
        studentView.showMessage("--------- FIND AND SORT ----------");
        String name = validation.validateStudentName("Enter student name: ", 1);
        List<Student> listStudentByName = studentService.getStudentByName(name);
        listStudentByName.sort((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName()));
        studentView.showListOfStudent(listStudentByName);
    }

    public void report() {
        studentView.showMessage("--------- REPORT ----------");
        reportService.getListReport();
    }
}
