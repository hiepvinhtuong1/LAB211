/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author Admin
 */
public class Manager {

    private static Scanner sc = new Scanner(System.in);
    private List<Doctor> doctorList;

    public Manager() {
        doctorList = new ArrayList<>();
    }

    public boolean addDoctor() {
        String code, name, specialization;
        int availability;

        try {
            code = Validation.getCode("Enter code: ", doctorList, 1);

            System.out.print("Enter name: ");
            name = sc.nextLine().trim();

            System.out.print("Enter Specialization: ");
            specialization = sc.nextLine().trim();

            availability = Validation.getInt("Enter Availability: ", 0, null);

            doctorList.add(new Doctor(code, name, specialization, availability));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean updateDoctor() {
        String code, name, specialization, availability;

        try {
            code = Validation.getCode("Enter code: ", doctorList, 2);
            Doctor doctor = Validation.getDoctor(code, doctorList);
            
            System.out.print("Enter name: ");
            name = sc.nextLine().trim();
            if (name.length() != 0) {
                doctor.setName(name);
            }
            
            System.out.print("Enter Specialization: ");
            specialization = sc.nextLine().trim();
            if (specialization.length() != 0) {
                doctor.setName(name);
            }
            
            System.out.print("Enter Availability: ");
            availability = sc.nextLine().trim();
            if (availability.length() != 0){
                Integer convert = Validation.getInt(availability, 0, null);
                doctor.setAvailability(convert);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteDoctor() {
        String code;

        try {
            code = Validation.getCode("Enter code: ", doctorList, 2);
            Doctor doctor = Validation.getDoctor(code, doctorList);
            doctorList.remove(doctor);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public void searchDoctor() {
        String text;

        System.out.print("Enter text: ");
        text = sc.nextLine().trim();

        // System.out.println("%s%-20s%-20s%4d", "Code", "Name", "Specialization", "Availability");
        System.out.println("--------- Result ----------");
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Code", "Name", "Specialization", "Availability");
        if (text.length() == 0) {
            for (Doctor doctor : doctorList) {
                System.out.println(doctor.toString());
            }
        } else {
            for (Doctor doctor : doctorList) {
                if (doctor.getName().equals(text)
                        || doctor.getCode().equals(text)
                        || doctor.getSpecialization().equals(text)
                        || text.equals(Integer.toString(doctor.getAvailability()))) {
                    System.out.println(doctor.toString());
                }
            }
        }
    }
}
