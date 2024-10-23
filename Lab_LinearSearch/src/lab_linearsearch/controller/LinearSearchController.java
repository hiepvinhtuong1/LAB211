/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_linearsearch.controller;

import java.util.Random;
import java.util.Scanner;
import lab_linearsearch.model.LinearSearchModel;
import lab_linearsearch.view.LinearSearchView;

/**
 *
 * @author Admin
 */
public class LinearSearchController {

    private LinearSearchModel model;
    private LinearSearchView view;
    private Scanner scanner = new Scanner(System.in);

    public LinearSearchController(LinearSearchModel model, LinearSearchView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        System.out.println("Enter number of array: ");
        int n = scanner.nextInt();
        int[] array = generateRandomArray(n);
        model.setArray(array);

        view.displayArray(model.getArray(), "The array: ");

        // Nhập số cần tìm kiếm
        System.out.print("Enter the number to search: ");
        int searchNumber = scanner.nextInt();

        // Thực hiện tìm kiếm
        int index = model.linearSearch(searchNumber);

        // Hiển thị kết quả tìm kiếm
        view.displaySearchResult(index, searchNumber);

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
