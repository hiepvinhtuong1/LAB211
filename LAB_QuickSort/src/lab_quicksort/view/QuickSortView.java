/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_quicksort.view;

/**
 *
 * @author Admin
 */
public class QuickSortView {
    
    public void displayArray(int[] array, String message){
        System.out.println(message);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
