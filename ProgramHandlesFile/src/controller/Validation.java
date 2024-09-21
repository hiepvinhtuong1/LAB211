/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int n = 0;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min + "->" + max);
            }
        }
        return n;
    }

    public static double getDouble(String s) {
        double n = 0;
        try {
            n = Double.parseDouble(s);
            if (n < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
        }
        return n;
    }

    public static double checkInputMoney(String msg) {
        System.out.print(msg);
        while (true) {
            try {
                String inputMoney = sc.nextLine().trim();
                return Validation.getDouble(inputMoney);
            } catch (NumberFormatException e) {
                System.err.println("Please enter money must be double and greater or equal 0");
            }
        }
    }

    public static String checkInputPathFile(String msg) {
        while (true) {
            System.out.print(msg);
            String pathFile = sc.nextLine().trim();
            if (pathFile.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                File file = new File(pathFile);
                if (file.exists()) {
                    return pathFile;
                }
                try {
                    file.createNewFile();
                    System.out.println("Created new file successfull");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
