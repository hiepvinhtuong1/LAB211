/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertsort;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validition {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) throws RuntimeException{
        int n;
            try {
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) {
                    return n;
                }
                throw new NumberFormatException("Please enter an integer number in range: " + min + "->" + max);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Please enter an integer number in range: " + min + "->" + max);
            }
    }
}
