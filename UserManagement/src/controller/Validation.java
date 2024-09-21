/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Scanner;
import model.User;

/**
 *
 * @author Admin
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) throws RuntimeException {
        int n;
        System.out.print(msg);
        try {
            n = Integer.parseInt(sc.nextLine().trim());
            if (n >= min && n <= max) {
                return n;
            }
            throw new NumberFormatException("Please enter an integer number in range: " + min + "->" + max);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please enter an integer number in range: " + min + "->" + max);

        }
    }

    public static String checkUserName(String msg, List<User> uList) throws Exception {
        String s;
        System.out.print(msg);
        s = sc.nextLine().trim();
        if (!s.matches("^[^ ]{5,}$")) {
            throw new Exception("Username must be at least 5 characters and no spaces!");
        }

        if (getUser(s, uList) != null) {
            throw new Exception("Username is not allowed to coincide with the existing username in the database.");
        }
        return s;
    }

    public static String checkPassword(String msg) throws Exception {
        String s;
        System.out.print(msg);
        s = sc.nextLine().trim();
        if (!s.matches("^[^ ]{6,}$")) {
            throw new Exception("Password must be at least 6 characters and no spaces!");
        }
        return s;
    }

    public static User getUser(String username, List<User> uList) {
        for (User u : uList) {
            if (u.getUserName().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
