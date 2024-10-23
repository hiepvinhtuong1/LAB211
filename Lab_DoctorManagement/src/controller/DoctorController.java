/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Scanner;
import model.Doctor;
import model.ManagementDoctor;
import utils.Validation;
import view.DoctorView;

/**
 *
 * @author Admin
 */
public class DoctorController {

    private Scanner sc = new Scanner(System.in);
    private DoctorView view;
    private ManagementDoctor management;
    private Validation validation;

    public DoctorController(DoctorView view, ManagementDoctor management, Validation validation) {
        this.view = view;
        this.management = management;
        this.validation = validation;
    }

    public void start() {
        management.addFakeData();
        while (true) {
            view.showMenu();
            int option = validation.validateOption("Enter your option: ", 1, 5);
            switch (option) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    view.showMessage("Exiting program.");
                    return;
                default:
                    view.showMessage("Invalid option. Please try again.");
            }
        }
    }

    private void addDoctor() {
        String code, name, specialization;
        int availability;

        try {
            code = validation.validateCode("Enter doctor code: ");
            name = validation.validateName("Enter doctor name: ", 1);
            specialization = validation.validateSpecialization("Enter doctor specialization: ", 1);
            availability = validation.validateAvailability("Enter doctor availability: ", 1, 10, 1);

            Doctor newDoctor = new Doctor(code, name, specialization, availability);

            if (management.addDoctor(newDoctor)) {
                System.out.println("Add successfull");
                System.out.println("New Doctor: ");
                System.out.println(newDoctor.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void updateDoctor() {
        String code, name, specialization;
        int availability;

        try {
            code = validation.validateCode("Enter doctor code: ");
            name = validation.validateName("Enter doctor name: ", 2);
            specialization = validation.validateSpecialization("Enter doctor specialization: ", 2);
            availability = validation.validateAvailability("Enter doctor availability: ", 1, 10, 2);

            Doctor tempDoctor = management.getDoctorByCode(code);
            System.out.println("Doctor before update: ");
            System.out.println(tempDoctor.toString());

            if (name == null) {
                name = tempDoctor.getName();
            }
            if (specialization == null) {
                specialization = tempDoctor.getSpecialization();
            }
            if (availability == -1) {
                availability = tempDoctor.getAvailability();
            }
            Doctor newDoctor = new Doctor(code, name, specialization, availability);

            if (management.updateDoctor(newDoctor)) {
                System.out.println("Update successfull");
                System.out.println("Doctor after update: ");
                System.out.println(newDoctor.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void deleteDoctor() {
        String code;
        try {
            code = validation.validateCode("Enter doctor code: ");
            if (management.deleteDoctor(code)) {
                System.out.println("Delete successfull");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void searchDoctor() {
        view.displaySearchMenu();
        int option = validation.validateOption("Enter your option: ", 1, 4);
        String input = sc.nextLine();
        try {
            HashMap<String, Doctor> doctors =  management.searchDoctor(input, option);
            for (Doctor doctor : doctors.values()) {
                System.out.println(doctor.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
