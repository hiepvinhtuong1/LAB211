/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Manager;
import controller.Validation;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {
    private static String[] ops = {
        "Create a new account",
        "Login system",
        "Exit"
    };
    
    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i+1) + " " + ops[i]);
        }
        return Validation.getInt("Your choice: ", 1, ops.length);
    }
    
    public static void display() {
        Manager m = new Manager();
        int choice;
        do {            
            choice = getChoice();
            switch (choice) {
                case 1:
                    m.addAccount();
                    break;
                case 2:
                    m.find();
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }
}
