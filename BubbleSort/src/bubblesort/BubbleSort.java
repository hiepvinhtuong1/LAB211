/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class BubbleSort {
    
    public static void main(String[] args) {
       
        Validation validation = new Validation();
        int n = validation.getInt();
        int[] a = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n);
        }
        
        System.out.println("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        
         System.out.println("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
