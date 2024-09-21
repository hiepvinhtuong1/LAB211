/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.Scanner;
import manager.Management;
import manager.Validation;

/**
 *
 * @author Admin
 */
public class Menu {

    private static String[] ops = {
        "Add worker",
        "Up salary",
        "Down salary",
        "Display information salary",
        "Display information of all worker",
        "Exit"
    };

    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1 + "." + ops[i]));
        }
        return Validation.getInt("Your choice: ", 1, ops.length);
    }

    public static void display() {
        Management m = new Management();
        int choice;
        do {
            System.out.println("======== Worker Management =========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.println("--------- Add Worker ----------");
                    m.addWorker();
                    break;
                case 2:
                    System.out.println("------- Up Salary --------");
                    m.updateSalary(1);
                    break;
                case 3:
                    System.out.println("------- Down Salary --------");
                    m.updateSalary(2);
                    break;
                case 4:
                    System.out.println("--------------------Display Information Salary-----------------------");
                    m.getInformation();
                    break;
                case 5:
                    System.out.println("--------------------Display Information Of All Workers-----------------------");
                    m.displayAll();
                    break;
                case 6:
                    break;
            }
        } while (choice != 5);
    }
}
