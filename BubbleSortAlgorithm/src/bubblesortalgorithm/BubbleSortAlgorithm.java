/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesortalgorithm;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BubbleSortAlgorithm {

    // check user use input a positive integer
    private static int checkInputPositiveInteger(String numberOfArray) {
        try {

            if (numberOfArray == null || numberOfArray.trim().isEmpty()) {
                throw new IllegalArgumentException("number of array can not be empty");
            }

            if (numberOfArray.matches("^[0-9]+.[0-9]+$")) {
                throw new IllegalArgumentException("number of array can not be float");
            }

            long number = Long.parseLong(numberOfArray);

            if (number <= 0) {
                throw new IllegalArgumentException("number of array can not be negative number");
            }

            if (number > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("number of array can not exceed the max of integer ");
            }
            return (int) number;
        } catch (NumberFormatException e) {
            System.out.println("number of array can not be letter");
        }

        return -1;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter number of array");
                String numberOfArray = sc.nextLine();
                int sizeOfArray = checkInputPositiveInteger(numberOfArray);
                if (sizeOfArray != -1) {
                    Random rand = new Random();
                    int[] array = new int[sizeOfArray];
                    for (int i = 0; i < array.length; i++) {
                        array[i] = rand.nextInt(sizeOfArray);
                    }
                    System.out.print("Unsorted array: ");
                    print(array);
                    bubbleSort(array);
                    System.out.println("");
                    System.out.print("Sorted array: ");
                    print(array);
                    break;
                } else {
                    System.out.println("please enter again");
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
