/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Arrays;
import java.util.Scanner;
import service.StudentRule;

/**
 *
 * @author Admin
 */
public class Validation {

    private final Scanner SCANNER = new Scanner(System.in);
    private final StudentRule studentRule;

    public Validation(StudentRule studentRule) {
        this.studentRule = studentRule;
    }

    /**
     * Check the Id entered from the keyboard
     *
     * @param msg: message to display prompts the user for input
     * @param idRule: Rules for student IDs. Includes prefixes for different
     * student types. format
     * @return : return a valid id input by user
     */
    public String validateId(String msg, String[] idRule) {
        // input:  User enters id from keyboard
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Id is empty!");
                }
                for (String prefixId : idRule) {
                    if (input.startsWith(prefixId) && input.matches(prefixId + "[0-9]{6}")) {
                        return input;
                    }
                }
                throw new IllegalArgumentException("Error: Id is not in correct format\n "
                        + "Please enter in the following format: HEXXXXXX where X is a digit");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Check the student name entered from the keyboard
     *
     * @param msg: message to display prompts the user for input
     * @return : return a valid student name input
     */
    public String validateStudentName(String msg, int mode) {
        // input: User enters student name from keyboard;
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if ((input == null || input.trim().isEmpty()) && mode == 1) {
                    throw new IllegalArgumentException("Error: Student name is empty!");
                }
                if (input.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Error: Student name contains numbers!");
                }
                if (input.matches("[!@#\\$%\\^&*\\(\\)]")) {
                    throw new IllegalArgumentException("Error: Student name contains special character!");
                }
                if (input.matches("^[A-Za-z ]+$")) {
                    return input;
                }
                throw new IllegalArgumentException("Error: Semester is not correct format! \n"
                        + "Please enter a student name consisting of only letters [A-Z] and [a-z] and space");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Check the semester entered from the keyboard
     *
     * @param msg: message to display prompts user for input
     * @param semesterRule: Rules for semesters. Includes prefixes for different
     * semester.
     * @return : return a valid semester input
     */
    public String validateSemester(String msg, String[] semesterRule, int mode) {
        // input: User enters semester from keyboard
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if ((input == null || input.trim().isEmpty()) && mode == 1) {
                    throw new IllegalArgumentException("Error: Semester is empty!");
                }
                for (String prefixSemester : semesterRule) {
                    if (input.startsWith(prefixSemester) && input.matches(prefixSemester + "[0-9]{4}")) {
                        return input;
                    }
                    if (input.startsWith(prefixSemester)) {
                        System.out.println(input);
                    }
                }
                throw new IllegalArgumentException("Error: Semester is not correct format! \n"
                        + "Please enter course name in " + Arrays.toString(semesterRule) + "XXXX with X is a digit");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Check the course name entered from the keyboard
     *
     * @param msg: message to display prompts user for input
     * @param courseNameOption: List of course names available in the system.
     * @return: return a valid course name input
     */
    public String validateCourseName(String msg, String[] courseNameOption, int mode) {
        // input: user input course name from keyboard
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if ((input == null || input.trim().isEmpty()) && mode == 1) {
                    throw new IllegalArgumentException("Error: Course name is empty!");
                }
                for (String courseName : courseNameOption) {
                    if (input.equals(courseName)) {
                        return input;
                    }
                }
                throw new IllegalArgumentException("Error: Course name is not exist! \n"
                        + "Please enter course name in " + Arrays.toString(courseNameOption));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * check the selection entered from the keyboard
     *
     * @param msg: message to display prompts user for input
     * @param firstOption: first option for user
     * @param secondOption: second option for user
     * @param err: message to display errs and conditions
     * @return
     */
    public boolean validateConfirm(String msg, String err, String firstOption, String secondOption) {
        // input: user input selection from keyboard
        String input;
        while (true) {
            try {
                input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Selection is empty! ");
                }
                if (input.equals(firstOption)) {
                    return true;
                } else if (input.equals(secondOption)) {
                    return false;
                }
                throw new IllegalArgumentException(err);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Check if input is an integer from min to max
     *
     * @param msg: message to display prompts the user for input
     * @param min: the smallest value of the input
     * @param max: the maximum value of the input
     * @return: returns a valid integer value input by the user between min and
     * max
     */
    public int getInt(String msg, int min, int max) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty! ");
                }
                if (input.matches("^-?[0-9]+.[0.9]+$")) {
                    throw new IllegalArgumentException("Error: Input is floating number!");
                }
                long converted = Long.parseLong(input);

                if (converted < 0) {
                    throw new IllegalArgumentException("Error: Input is a negative integer!");
                }
                if (converted < min) {
                    throw new IllegalArgumentException("Error: Input < " + min + "Please enter input from " + min + "->" + max);
                }
                if (converted > max) {
                    throw new IllegalArgumentException("Error: Input > " + max + ", Please enter input from " + min + "->" + max);
                }
                return (int) converted;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min + "->" + max);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
