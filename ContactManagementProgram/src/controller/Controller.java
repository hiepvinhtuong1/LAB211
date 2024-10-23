/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.Contact;
import model.PhoneBook;
import utils.Validation;

/**
 *
 * @author Admin
 */
public class Controller {

    Scanner sc = new Scanner(System.in);
    private final Validation validation;
    private final PhoneBook phoneBook;

    public Controller(Validation validation, PhoneBook phoneBook) {
        this.validation = validation;
        this.phoneBook = phoneBook;
    }

    public void showMenu() {
        System.out.println("========= Contact program =========\n"
                + "1. Add a Contact\n"
                + "2. Display all Contact\n"
                + "3. Delete a Contact\n"
                + "4. Exit");
    }

    public void run() {
        while (true) {
            showMenu();
            int choice;
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("-------- Add a Contact --------");
                    addContact();
                    break;
                case 2:
                    System.out.println("-----Display all contact------");
                    displayAllContact();
                    break;
                case 3:
                    System.out.println("-----Delete a contact-----");
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Exit succesfully");
                    return; // Exit the program
            }
        }
    }

    /**
     * function: create and add a contact to phonebook
     */
    public void addContact() {
        String name;
        String group;
        String address;
        String phone;

        name = validation.validateName();
        group = validation.validateGroup();
        address = validation.validateAddres();
        phone = validation.validatePhone();

        Contact newContact = new Contact(name, group, address, phone);
        if (phoneBook.addContact(newContact)) {
            System.out.println("Add successfull!!");
            System.out.println(newContact.toString());
        } else {
            System.out.println("Add false");
        }
    }
    
    /**
     * function: display a contact
     */
    public void displayAllContact() {
        System.out.printf("%-5s %-20s %-20s %-20s %-20s %-20s %-20s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact contact : phoneBook.getAllContact()) {
            System.out.println(contact.toString());
        }
    }
    
    /**
     * function: delete a contact by id
     */
    public void deleteContact() {
        int id;
        id = validation.getId();
        if (phoneBook.deleteContact(id) == true) {
            System.out.println("Succesfull");
        }
    }
}
