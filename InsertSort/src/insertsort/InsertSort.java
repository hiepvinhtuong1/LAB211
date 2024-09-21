/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package insertsort;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class InsertSort {

    private static int[] a;

    public static void inputArray() {
        while (true) {
            try {
                int numberOfArray = Validition.getInt("Enter number of array: ", 0, Integer.MAX_VALUE);
                a = new int[numberOfArray];
                Random rand = new Random();
                for (int i = 0; i < numberOfArray; i++) {
                    a[i] = rand.nextInt(numberOfArray);
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void printArray(String msg) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i] + "]");
            }
        }
    }
    
    public static void insertSort() {
        int index;
        for (int i = 1; i < a.length; i++) {
            index = i;
            int newNumber = a[i];
            while (index > 0 && a[index-1] > newNumber) {
                a[index] = a[index-1];
                index--;
            }
            a[index] = newNumber;
        }
    }
}
