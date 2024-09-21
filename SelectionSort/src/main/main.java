/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
        selectionsort.SelectionSort.inputArray();
        selectionsort.SelectionSort.printArray("Unsorted array: ");
        selectionsort.SelectionSort.selectSort();
        System.out.println("");
        selectionsort.SelectionSort.printArray("Sorted array: ");
    }
}
