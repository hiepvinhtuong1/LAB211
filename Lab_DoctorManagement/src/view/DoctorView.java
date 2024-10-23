/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Admin
 */
public class DoctorView {

    public void showMenu() {
        System.out.println("========= Doctor Management ==========\n"
                + "1.	Add Doctor\n"
                + "2.	Update Doctor\n"
                + "3.	Delete Doctor\n"
                + "4.	Search Doctor\n"
                + "5.	Exit");
    }
    
    public void displaySearchMenu() {
        System.out.println("Search Doctor by:");
        System.out.println("1. Code");
        System.out.println("2. Name");
        System.out.println("3. Specialization");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
    
     public void showMessage(String message) {
        System.out.println(message);
    }
}
