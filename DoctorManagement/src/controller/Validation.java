/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author Admin
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static String getCode(String msg, List<Doctor> dList, int mode) throws Exception {
        String code = "";
        System.out.print(msg);
        code = sc.nextLine();
        if (code.length() == 0) {
            throw new Exception("Code is not null in the DB");

        } else if (mode == 1 && getDoctor(code, dList) != null) {
            throw new Exception("Doctor code is not  duplicate in DB");

        } else if (mode == 2) {
            if (dList.isEmpty()) {
                throw new Exception("Database does not exist");
            } else if (getDoctor(code, dList) == null) {
                throw new Exception("Doctor code does not exist");
            }
        }
        return code;
    }

    public static Doctor getDoctor(String code, List<Doctor> dList) {
        for (Doctor doctor : dList) {
            if (doctor.getCode().equals(code)) {
                return doctor;
            }
        }
        return null;
    }

    public static Integer getInt(String s, Integer min, Integer max) throws RuntimeException {
        int n = Integer.parseInt(sc.nextLine().trim());
        if (min != null && max != null) {
            if (n >= min && n <= max) {
                return n;
            }
            throw new NumberFormatException("Please enter an integer number in range " + min + "->" + max);
        } else if (min != null) {
            if (n >= min) return n;
            throw new NumberFormatException("Please enter an integer number greater or equal " + min);
        }
        return null;
    }
}
