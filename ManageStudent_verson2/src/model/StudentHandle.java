/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import utils.StudentRule;

/**
 *
 * @author Admin
 */
public class StudentHandle {

    public StudentHandle() {
    }

    private final List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }

    public Student getStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getListStudentById(String id) {
        List<Student> listStudentById = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                listStudentById.add(student);
            }
        }
        return listStudentById;
    }

    public List<Student> getStudentByName(String studentNameToFind) {
        List<Student> listStudentByName = new ArrayList<>();
        for (Student student : studentList) {
            String studentName = student.getStudentName();
            String lowerStudentNameToFind = studentNameToFind.toLowerCase();
            String lowerStudentName = studentName.toLowerCase();
            if (lowerStudentName.contains(lowerStudentNameToFind)) {
                listStudentByName.add(student);
            }
        }
        return listStudentByName;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void updateStudent(Student studentToUpdate, Student newStudent) {
        studentToUpdate.setStudentName(newStudent.getStudentName());
        studentToUpdate.setSemester(newStudent.getSemester());
        studentToUpdate.setCourseName(newStudent.getCourseName());
    }

    public void updateStudentName(String studentId, String studentName) {
        List<Student> listStudentById = getListStudentById(studentId);
        for (Student student : listStudentById) {
            student.setStudentName(studentName);
        }
    }

    public boolean deleteStudent(Student student) {
        return studentList.remove(student);
    }

    public boolean checkValidStudentCreate(Student studentNeedToCheck, StudentRule studentRule) throws Exception {
        Student studentInList = getStudentById(studentNeedToCheck.getId());

        if (studentInList == null) {
            return true;
        }

        if (!checkNameStudnet(studentInList.getStudentName(), studentNeedToCheck.getStudentName())) {

            System.out.println(checkNameStudnet(studentInList.getStudentName(), studentNeedToCheck.getCourseName()));
            throw new IllegalArgumentException("Error: The name does not match the name of the corresponding id");
        }

        List<String> courseOptionInSemester = new ArrayList<>();
        for (String courseNameElement : studentRule.getCourseNameOption()) {
            courseOptionInSemester.add(courseNameElement);
        }

        if (!checkSemester(studentNeedToCheck.getSemester(), courseOptionInSemester, studentRule.getSemesterRule())) {
            throw new IllegalArgumentException("Error: In" + studentNeedToCheck.getSemester() + " you have completed all the courses.");
        }

        if (!checkCourseName(studentNeedToCheck.getCourseName(), courseOptionInSemester)) {
            throw new IllegalArgumentException("Error: In" + studentNeedToCheck.getSemester() + " you have registerred " + studentNeedToCheck.getCourseName());
        }
        return true;
    }

    public boolean checkValidStudentUpdate(Student studentNeedToCheck, StudentRule studentRule) throws Exception {
        List<String> courseOptionInSemester = new ArrayList<>();
        for (String courseNameElement : studentRule.getCourseNameOption()) {
            courseOptionInSemester.add(courseNameElement);
        }

        if (!checkSemester(studentNeedToCheck.getSemester(), courseOptionInSemester, studentRule.getSemesterRule())) {
            throw new IllegalArgumentException("Error update: In" + studentNeedToCheck.getSemester() + " you have completed all the courses.");
        }

        if (!checkCourseName(studentNeedToCheck.getCourseName(), courseOptionInSemester)) {
            throw new IllegalArgumentException("Error update: In" + studentNeedToCheck.getSemester() + " you have registerred " + studentNeedToCheck.getCourseName());
        }
        return true;
    }

    public boolean checkNameStudnet(String studentNameInList, String studentNameNeedToCheck) {
        return studentNameInList.equals(
                studentNameNeedToCheck
        );
    }

    public boolean checkSemester(String semesterNeedToCheck, List<String> courseOptionInSemester, String[] semesterRules) {
        int totalCourseInSemester = 0;
        for (Student student : studentList) {
            if (student.getSemester().equals(semesterNeedToCheck)) {
                totalCourseInSemester++;
                courseOptionInSemester.remove(student.getCourseName());
            }
        }
        return totalCourseInSemester != semesterRules.length;
    }

    public boolean checkCourseName(String courseNameNeedToCheck, List<String> courseOptionInSemester) {
        for (String course : courseOptionInSemester) {
            if (course.equals(courseNameNeedToCheck)) {
                return true;
            }
        }
        return false;
    }

}
