/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesort;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    private final Scanner SCANNER = new Scanner(System.in);

    public int getInt() {
        while (true) {
            try {
                System.out.println("Enter number of array: ");

                String input = SCANNER.nextLine();
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
