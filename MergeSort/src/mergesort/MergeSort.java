/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class MergeSort {

    public static int[] inputArray() {
        int a[];
        while (true) {
            try { 
                System.out.print("Enter number of array: ");
                int numberOfArray = Validition.getInt(null, 1, Integer.MAX_VALUE);
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
        return a;
    }

    public static void printArray(String msg, int[] a) {
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

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

        int[] leftSorted = mergeSort(leftHalf);
        int[] rightSorted = mergeSort(rightHalf);

        return merge(leftSorted, rightSorted);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                k++;
                i++;
            } else {
                result[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
}
