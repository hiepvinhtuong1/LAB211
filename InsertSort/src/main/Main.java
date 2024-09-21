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
    public static void main(String[] agrs) {
        insertsort.InsertSort.inputArray();
        insertsort.InsertSort.printArray("Unsorted array: ");
        insertsort.InsertSort.insertSort();
        System.out.println("");
        insertsort.InsertSort.printArray("Sorted array: ");
    }
}
