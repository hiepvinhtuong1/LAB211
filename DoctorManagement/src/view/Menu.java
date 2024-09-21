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
    private static Scanner sc = new Scanner(System.in);
    
    private static String ops[] = {
        "Add Doctor",
        "Update Doctor",
        "Delete Doctor",
        "Search Doctor",
        "Exit"
    };

    private static int getChoice() {
        for (int i = 0; i < ops.length; i++) {
            System.out.println(i + 1 + ". " + ops[i]);
        }
        System.out.print("Your choice: ");
        String choice = sc.nextLine().trim();
        return Validation.getInt(choice, 1, ops.length);
    }

    public static void display() {
        Manager m = new Manager();
        int choice;
        do {
            System.out.println("========= Doctor Management ==========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.println("--------- Add Doctor ----------");
                    if (m.addDoctor() == true) {
                        System.out.println("Add sucessfully");
                    } else {
                        System.out.println("Add failure");
                    }
                    ;
                    break;
                case 2:
                    System.out.println("--------- Update Doctor ----------");
                    if (m.updateDoctor()== true) {
                        System.out.println("Update sucessfully");
                    } else {
                        System.out.println("Update failure");
                    }
                    ;
                    break;
                case 3:
                    System.out.println("--------- Delete Doctor ----------");

                    if (m.addDoctor() == true) {
                        System.out.println("Delete sucessfully");
                    } else {
                        System.out.println("Delete failure");
                    }
                    ;
                    break;
                case 4:
                    System.out.println("--------- Search Doctor  ----------");
                    if (m.addDoctor() == true) {
                        System.out.println("Search sucessfully");
                    } else {
                        System.out.println("Search failure");
                    }
                    ;
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
