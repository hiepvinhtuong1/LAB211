/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_quicksort.controller;

import java.util.Random;
import java.util.Scanner;
import lab_quicksort.model.MergeSortModel;
import lab_quicksort.model.QuickSortModel;
import lab_quicksort.view.QuickSortView;

/**
 *
 * @author Admin
 */
public class QuickSortController {

    private MergeSortModel model;
    private QuickSortView view;
    private Scanner scanner = new Scanner(System.in);

    public QuickSortController(MergeSortModel model, QuickSortView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        System.out.println("Enter number of array: ");
        int n = scanner.nextInt();
        int[] array = generateRandomArray(n);
        model.setArray(array);
        
        view.displayArray(array, "Unsorted array: ");
        model.mergeSort(0, array.length-1);
        view.displayArray(array, "Sorted array");

    }

    public int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n);
        }
        return array;
    }

}
