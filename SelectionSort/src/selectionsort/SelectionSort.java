/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectionsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class SelectionSort {

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
            if (a[i] != a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i] + "]");
            }
        }
        System.out.println("");
        System.out.println("test" + Arrays.toString(a));
    }

    public static void selectSort() {
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
