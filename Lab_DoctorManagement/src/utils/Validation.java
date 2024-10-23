/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    private final Scanner SCANNER = new Scanner(System.in);

    public String validateCode(String msg) {
        // input:  User enters id from keyboard
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Id is empty!");
                }
                if (input.matches("DOC"+"[0-9]{3}")) return input;
                throw new IllegalArgumentException("Error: Code is not in correct format\n "
                        + "Please enter in the following format: DOCXXX where X is a digit");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    public String validateName(String msg, int mode) {
        // input: User enters student name from keyboard;
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if ((input == null || input.trim().isEmpty()) && mode == 1) {
                    throw new IllegalArgumentException("Error: Doctor name is empty!");
                } else if ((input == null || input.trim().isEmpty()) && mode == 2) {
                    return input;
                }
                if (input.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Error: Doctor name contains numbers!");
                }
                if (input.matches("[!@#\\$%\\^&*\\(\\)]")) {
                    throw new IllegalArgumentException("Error: Doctor name contains special character!");
                }
                if (input.matches("^[A-Za-z ]+$")) {
                    return input;
                }
                throw new IllegalArgumentException("Error: Doctor name is not correct format! \n"
                        + "Please enter a student name consisting of only letters [A-Z] and [a-z] and space");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    public String validateSpecialization(String msg, int mode) {
        // input: User enters student name from keyboard;
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
                if ((input == null || input.trim().isEmpty()) && mode == 1) {
                    throw new IllegalArgumentException("Error: Doctor name is empty!");
                } else if ((input == null || input.trim().isEmpty()) && mode == 2) {
                    return input;
                }
                if (input.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Error: Doctor name contains numbers!");
                }
                if (input.matches("[!@#\\$%\\^&*\\(\\)]")) {
                    throw new IllegalArgumentException("Error: Doctor name contains special character!");
                }
                if (input.matches("^[A-Za-z ]+$")) {
                    return input;
                }
                throw new IllegalArgumentException("Error: Doctor name is not correct format! \n"
                        + "Please enter a student name consisting of only letters [A-Z] and [a-z] and space");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    public int validateAvailability(String msg, int min, int max, int mode) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = SCANNER.nextLine();
               if ((input == null || input.trim().isEmpty()) && mode == 1) {
                    throw new IllegalArgumentException("Error: Doctor name is empty!");
                } else if ((input == null || input.trim().isEmpty()) && mode == 2) {
                    return -1;
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
    
     public int validateOption(String msg, int min, int max) {
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
