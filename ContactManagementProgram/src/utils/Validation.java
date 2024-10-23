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

    Scanner sc = new Scanner(System.in);

    public String validateName() {
        // input: User enters student name from keyboard;
        String input;
        while (true) {
            try {
                System.out.print("Enter Name: ");
                input = sc.nextLine();
                if ((input == null || input.trim().isEmpty())) {
                    throw new IllegalArgumentException("Error: Student name is empty!");
                }
                if (input.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Error: Student name contains numbers!");
                }
                if (input.matches("[!@#\\$%\\^&*\\(\\)]")) {
                    throw new IllegalArgumentException("Error: Student name contains special character!");
                }
                if (input.matches("^[A-Za-z]+ [A-Za-z]+$")) {
                    return input.trim();
                }
                throw new IllegalArgumentException("Error: Student name is not correct format! \n"
                        + "Please enter a student name consisting of only letters [A-Z] and [a-z] and space");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String validateGroup() {
        String input;
        while (true) {
            try {
                System.out.print("Enter Group: ");

                input = sc.nextLine();
                if ((input == null || input.trim().isEmpty())) {
                    throw new IllegalArgumentException("Error: Group is empty!");
                }
                return input.trim();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String validateAddres() {
        String input;
        while (true) {
            try {
                System.out.print("Enter Address: ");

                input = sc.nextLine();
                if ((input == null || input.trim().isEmpty())) {
                    throw new IllegalArgumentException("Error: Address is empty!");
                }
                return input.trim();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String validatePhone() {
        String input;
        while (true) {
            try {
                System.out.print("Enter Phone: ");

                input = sc.nextLine();
                if ((input == null || input.trim().isEmpty())) {
                    throw new IllegalArgumentException("Error: Phone is empty!");
                }
                if (input.matches("[0-9]{10}")
                        || input.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")
                        || input.matches("[0-9]{3}.[0-9]{3}.[0-9]{4}")
                        || input.matches("[0-9]{3} [0-9]{3} [0-9]{4}")
                        || input.matches("[0-9]{3} [0-9]{3} [0-9]{4} (x|ext)[0-9]{4}")
                        || input.matches("\\([0-9]{3}\\) [0-9]{3} [0-9]{4}")) {
                    return input;
                }
                throw new IllegalArgumentException("Please input Phone flow\n"
                        + " 1234567890\n"
                        + " 123-456-7890 \n"
                        + " 123-456-7890 x1234\n"
                        + " 123-456-7890 ext1234\n"
                        + " (123)-456-7890\n"
                        + " 123.456.7890\n"
                        + " 123 456 7890");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    public int getId() {
        while (true) {
            try {
                System.out.println("Enter Id: ");

                String input = sc.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Input is empty!");
                }
                if (input.contains(".")) {
                    throw new IllegalArgumentException("Error: Input is floating-point number!");
                }

                if (!input.matches("-?[0-9]+")) {
                    throw new IllegalArgumentException("Error: Input contains letters, please enter a integer!");
                }

                long inputParseInt = Long.parseLong(input);

                if (inputParseInt <= 0) {
                    throw new IllegalArgumentException("Error: The input can not <= 0!");
                }

                if (inputParseInt > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException("Error: The input exceed Integer!");
                }

                return (int) inputParseInt;

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
