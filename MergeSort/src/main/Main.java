/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        int[] array = mergesort.MergeSort.inputArray();
        mergesort.MergeSort.printArray("Unsorted aray: ", array);
        int[] mergeSort = mergesort.MergeSort.mergeSort(array);
        System.out.println("");
        mergesort.MergeSort.printArray("Sorted array: ", array);

    }
}
