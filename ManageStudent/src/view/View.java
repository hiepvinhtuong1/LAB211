/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import utils.Validation;
import controller.StudentController;

/**
 *
 * @author Admin
 */
public class View {

    private final StudentController studentConTroller = new StudentController();
    private final Validation validation = new Validation();

    private String ops[] = {
        "Create",
        "Find and Sort",
        "Update and Delete",
        "Report",
        "Exit"
    };

    private  int getChoice() {
        for (int i = 0; i < ops.length; i++) {
            System.out.println(i + 1 + ". " + ops[i]);
        }
        return validation.getInt("Enter your choice: ", 1, ops.length);
    }

    public  void display() {
        int choice;
        do {
            System.out.println("========= Student Management ==========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.println("--------- CREATE ----------");
                    studentConTroller.createListStudent();
                  
                    break;
                case 2:
                    System.out.println("--------- FIND AND SORT ----------");
                    studentConTroller.findAndSort();
                    break;
                case 3:
                    System.out.println("--------- UPDATE AND DELETE  ----------");
                    studentConTroller.updateAndDelete();
                    break;
                case 4:
                    System.out.println("--------- REPORT ----------");
                    studentConTroller.report();
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
