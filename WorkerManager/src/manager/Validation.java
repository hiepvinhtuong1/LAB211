/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.List;
import java.util.Scanner;
import object.Worker;

/**
 *
 * @author Admin
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min + "->" + max);
            }
        }
        return n;
    }

    public static double getDouble(String msg, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number in range: " + min + "->" + max);
            }
        }
        return n;
    }

    public static String getCode(String msg, String err, int mode, List<Worker> wList) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            // MODE
            // 1: input - id not exist
            // 2: update - id exist
            if (!s.isEmpty()) {
                if ((mode == 1 && getWorker(s, wList)  == null )
                        || (mode == 2 && getWorker(s, wList) != null)) {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }

    public static Worker getWorker(String id, List<Worker> wList) {
        for (Worker o : wList) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }
}
