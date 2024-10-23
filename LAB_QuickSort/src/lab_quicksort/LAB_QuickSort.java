/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_quicksort;

import lab_quicksort.controller.QuickSortController;
import lab_quicksort.model.MergeSortModel;
import lab_quicksort.model.QuickSortModel;
import lab_quicksort.view.QuickSortView;

/**
 *
 * @author Admin
 */
public class LAB_QuickSort {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuickSortView view = new QuickSortView();
        //QuickSortModel model = new QuickSortModel();
        MergeSortModel model = new MergeSortModel();
        QuickSortController controller = new QuickSortController(model, view);
        controller.run();
    }
    
}
