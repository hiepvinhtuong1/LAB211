/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Admin
 */
public class StudentRule {

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

    public StudentRule() {
    }

    public String[] getIdRule() {
        return idRule;
    }

    public String[] getSemesterRule() {
        return semesterRule;
    }

    public String[] getCourseNameOption() {
        return courseNameOption;
    }
    
}
