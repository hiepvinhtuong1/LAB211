/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {
    
    Scanner sc = new Scanner(System.in);
    
    public int validateInt(String msg) {
        String input;
        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input can not be empty");
                }
                int value = Integer.parseInt(input);
                return value;
            } catch (Exception e) {
                System.err.println("Input must be number");
            }
        }
    }
}
