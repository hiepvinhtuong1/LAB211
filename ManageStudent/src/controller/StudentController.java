/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import model.Report;
import model.Student;
import utils.Validation;

/**
 *
 * @author Admin
 */
public class StudentController {

    private final List<Student> studentList = new ArrayList<>();

    private final Validation validation = new Validation();

    private final ReportController reportController = new ReportController();

    /**
     * Rules for student IDs. Includes prefixes for different student types.
     */
    private final String[] idRule = {
        "HE",
        "HA",
        "HI"
    };

    /**
     * Rules for semesters. Semesters can be used in the system.
     */
    private final String[] semesterRule = {
        "SPRING",
        "SUMMER",
        "FALL"
    };

    /**
     * List of course names available in the system.
     */
    private final String[] courseNameOption = {
        "Java",
        ".Net",
        "C/C++"
    };

    public StudentController() {
    }

    /**
     *
     * @param targetId: id to find student
     * @return : if found, return student, else return null
     */
    public Student getStudentById(String targetId) {
        for (Student student : studentList) {
            if (student.getId().equals(targetId)) {
                return student;
            }
        }
        return null;
    }

    /**
     *
     * @param targetId: id to filter students
     * @return : return a list of student with the same id
     */
    public List<Student> getListStudentById(String targetId) {
        List<Student> listStudentById = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getId().equals(targetId)) {
                listStudentById.add(student);
            }
        }
        return listStudentById;
    }

// Lấy các khóa học ở mảng courseNameOption rồi cho vào list
// Duyệt listStudent để tính xem kì này đã học được bao nhiều môn
// Nếu học đủ rồi thì bắt nhập kì mới, còn chưa học đủ thì hiện ra các môn còn lại
// Kiểm tra xem cái môn học đó tồn tại trong courseOptionInSemester không , nếu không tồn tại bắt nhập lại
    /**
     * function: check semester and courseName is valid
     *
     * @param listStudent: list of course and semester of student
     * @return semester and course in array string
     */
    public String[] inputValidSemesterAndCourse(List<Student> listStudent) {
        List<String> courseOptionInSemester = new ArrayList<>();
        for (String courseNameElement : courseNameOption) {
            courseOptionInSemester.add(courseNameElement);
        }
        String semester = validation.validateSemester("Enter semester: ", semesterRule);
        while (true) {
            int totalCourseInSemester = 0;
            for (Student student : listStudent) {
                if (student.getSemester().equals(semester)) {
                    totalCourseInSemester++;
                    courseOptionInSemester.remove(student.getCourseName());
                }
            }
            if (totalCourseInSemester == semesterRule.length) {
                System.err.println("In " + semester + " you have completed all the courses.");
                semester = validation.validateSemester("Enter semester: ", semesterRule);
            } else {
                System.out.println("Courses available in " + semester + " : ");
                for (int i = 0; i < courseOptionInSemester.size(); i++) {
                    System.out.println((i + 1) + ". " + courseOptionInSemester.get(i));
                }
                break;
            }
        }
        String[] courseOptionSemesterArray = new String[courseOptionInSemester.size()];
        for (int i = 0; i < courseOptionSemesterArray.length; i++) {
            courseOptionSemesterArray[i] = courseOptionInSemester.get(i);
        }
        String courseName = validation.validateCourseName(
                "Enter course name: ",
                courseOptionSemesterArray
        );

        String[] result = new String[2];
        result[0] = semester;
        result[1] = courseName;
        return result;
    }

    /**
     * function: create a new student
     */
    public void create() {
        String id, studentName, semester, courseName;

        id = validation.validateId("Enter id: ", idRule);
        List<Student> listStudentById = getListStudentById(id);
        if (!listStudentById.isEmpty()) {
            Student student = getStudentById(id);
            studentName = student.getStudentName();
        } else {
            studentName = validation.validateStudentName("Enter student name: ");
        }
        String[] semesterAndCourse = inputValidSemesterAndCourse(listStudentById);
        semester = semesterAndCourse[0];
        courseName = semesterAndCourse[1];
        studentList.add(new Student(id, studentName, semester, courseName));
        System.out.println("Add completed student!");

    }

// the first create( size of list == 0): create list of student with size = 5
// if size = 5, confirm want to continue "Y" continue, "N" stop
// more time to create, create a student  
    /**
     * function: create a new list student
     */
    public void createListStudent() {
        if (studentList.size() == 0) {
            while (true) {
                create();
                if (studentList.size() >= 5) {
                    System.out.println("Do you want to continue (Y/N)?");
                    boolean choice = validation.validateConfirm(
                            "Do you want to continue (Y/N)?",
                            "Please enter Y or N",
                            "Y",
                            "N"
                    );
                    if (choice) {
                        create();
                    } else {
                        break;
                    }
                }
            }
        } else {
            create();
        }

    }
// find list of student same name
// sort it by student name
    /**
     * function: find and sort
     */
    public void findAndSort() {
        if (studentList.isEmpty()) {
            System.out.println("List of student is empty!");
            return;
        }
        String nameOfStudent;
        List<Student> studentsByName = new ArrayList<>();

        nameOfStudent = validation.validateStudentName("Enter student name: ");
        List<Student> listStudentByName = getListStudentByName(nameOfStudent);

        if (!listStudentByName.isEmpty()) {
            Collections.sort(listStudentByName, (Student s1, Student s2) -> {
                return s1.getStudentName().compareTo(s2.getStudentName());
            });

            for (Student student : listStudentByName) {
                System.out.format("%-20s | %-15s | %-15s\n", student.getStudentName(), student.getSemester(), student.getCourseName());
            }
        } else {
            System.out.println("list of student find is empty");
        }
    }

    /**
     * function: find list of student contain name
     *
     * @param nameOfStudent: name of student want to find
     * @return list of student contain name
     */
    public List<Student> getListStudentByName(String nameOfStudent) {
        List<Student> listStudentByName = new ArrayList<>();
        for (Student student : studentList) {
            String studentName = student.getStudentName();
            String lowerNameOfStudent = nameOfStudent.toLowerCase();
            String lowerStudentName = studentName.toLowerCase();
            if (lowerStudentName.contains(nameOfStudent)) {
                listStudentByName.add(student);
            }
        }
        return listStudentByName;
    }

    public void updateAndDelete() {

        String id = validation.validateId("Enter id: ", idRule);
        if (getStudentById(id) == null) {
            System.out.println("Id of student does not exist in list");
            return;
        }
        System.out.print("Do you want to update(U) or delete(D) student: ");

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

        List<Student> listStudentById = getListStudentById(id);
        if (choiceOfUser) {
            System.out.println("List of Student By ID: ");
            for (int i = 0; i < listStudentById.size(); i++) {
                System.out.println((i + 1) + ". " + listStudentById.get(i).toString());
            }
            int indexUpdateStudent = validation.getInt(
                    "Enter index of student whom you want to update: ",
                    1,
                    listStudentById.size()
            );
            if (updateStudent(listStudentById.get(indexUpdateStudent))) {
                System.out.println("Update succesfully!");
            }
        } else {
            System.out.println("List of Student By ID: ");
            for (int i = 0; i < listStudentById.size(); i++) {
                System.out.println((i + 1) + ". " + listStudentById.get(i).toString());
            }
            int indexUpdateStudent = validation.getInt(
                    "Enter index of student whom you want to delete: ",
                    1,
                    listStudentById.size()
            );
            if (deleteStudent(listStudentById.get(indexUpdateStudent))) {
                System.out.println("Update succesfully!");
            }
        }
    }

    public void updateListStudent(String id, String name) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setStudentName(name);
            }
        }
    }

    public boolean updateStudent(Student studentToUpdate) {
        String updatedStudentName, updatedSemester, updatedCourseName;

        try {
            updatedStudentName = validation.validateStudentName("Enter student name want to update: ");
            if (updatedStudentName.length() != 0) {
                studentToUpdate.setStudentName(updatedStudentName);
                updateListStudent(studentToUpdate.getId(), updatedStudentName);
            }
            List<Student> listStudentById = getListStudentById(studentToUpdate.getId());
            List<String> courseOptionInSemester = new ArrayList<>();
            for (String courseNameElement : courseNameOption) {
                courseOptionInSemester.add(courseNameElement);
            }
            String semester = validation.validateSemester("Enter semester want to update: ", semesterRule);
            int totalCourseInSemester = 0;
            for (Student student : listStudentById) {
                if (student.getSemester().equals(semester)) {
                    totalCourseInSemester++;
                    courseOptionInSemester.remove(student.getCourseName());
                }
            }
            if (totalCourseInSemester == semesterRule.length) {
                throw new IllegalArgumentException("In " + semester + " you have completed all the courses.");
            } else {
                studentToUpdate.setSemester(semester);
                System.out.println("Courses available in " + semester + " : ");
                for (int i = 0; i < courseOptionInSemester.size(); i++) {
                    System.out.println((i + 1) + ". " + courseOptionInSemester.get(i));
                }
            }

            String courseName = validation.validateCourseName("Enter course name want to update: ", courseNameOption);
            if (!courseOptionInSemester.contains(courseName)) {
                throw new IllegalArgumentException("You have registered for " + courseName + " in " + semester);
            } else {
                Report reportBeforeUpdate = reportController.getReportByIdStudentAndCourse(studentToUpdate.getId(), studentToUpdate.getCourseName());
                reportController.updateReport(studentToUpdate.getId(), courseName, reportBeforeUpdate.getTotalCourse() - 1);
                studentToUpdate.setCourseName(courseName);
                Report reportToUpdate = reportController.getReportByIdStudentAndCourse(studentToUpdate.getId(), courseName);
                if (reportToUpdate == null) {
                    reportController.addReport(
                            studentToUpdate.getId(),
                            studentToUpdate.getStudentName(),
                            courseName,
                            1
                    );
                } else {
                    reportController.updateReport(
                            studentToUpdate.getId(),
                            courseName,
                            reportToUpdate.getTotalCourse() + 1);
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;

        }
    }

    public boolean deleteStudent(Student studentToDelete) {
        try {
            Report reportBeforeUpdate = reportController.getReportByIdStudentAndCourse(studentToDelete.getId(), studentToDelete.getCourseName());
            reportController.updateReport(studentToDelete.getId(), studentToDelete.getCourseName(), reportBeforeUpdate.getTotalCourse() - 1);
            return studentList.remove(studentToDelete);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public void displayStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    public void report() {
        if (studentList.isEmpty()) {
            System.out.println("List of student is empty!");
            return;
        }
//        clean data in report if exist before
        reportController.clearReport();

        for (Student student : studentList) {
            int totalOfCourse = 0;
            String studentID = student.getId();
            String course = student.getCourseName();
            String studentName = student.getStudentName();
            for (Student studentCountTotal : studentList) {
                boolean isEqualStudentIdAndCourse = studentID.equals(studentCountTotal.getId())
                        && course.equals(studentCountTotal.getCourseName());
                if (isEqualStudentIdAndCourse) {
                    totalOfCourse++;
                }
            }
            reportController.addReport(studentID, studentName, course, totalOfCourse);
        }

        reportController.printReport();
    }
}
