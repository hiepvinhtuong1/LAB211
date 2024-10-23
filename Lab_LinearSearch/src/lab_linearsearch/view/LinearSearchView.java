/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_linearsearch.view;

/**
 *
 * @author Admin
 */
public class LinearSearchView {

    public void displayArray(int[] array, String message) {
        System.out.println(message);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void displaySearchResult(int index, int searchNumber) {
        if (index == -1) {
            System.out.println("Number " + searchNumber + " not found in the array.");
        } else {
            System.out.println("Number " + searchNumber + " found at index: " + index);
        }
    }
}
