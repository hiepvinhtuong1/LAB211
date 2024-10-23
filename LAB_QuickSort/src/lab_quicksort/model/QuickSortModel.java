/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_quicksort.model;

/**
 *
 * @author Admin
 */
public class QuickSortModel {
    
    private int[] array;

    public QuickSortModel() {

    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
    
    
    
    public void quicksort(int left, int right){
        if (left < right) {
            int pivotIndex = partition(left, right);
            quicksort(left, pivotIndex-1);
            quicksort(pivotIndex+1, right);
        }
    }
    
//    private int partition(int left, int right) {
//        int mid = (left+right)/2;
//        int pivot = array[mid];
//        int i = left;
//        int j = right;
//        while (i <= j) {
//            while (array[i] < pivot){
//                i++;
//            }
//            
//            while (array[j] > pivot) {
//                j--;
//            }
//            
//            if (i <= j) {
//                swap(i,j);
//                i++;
//                j--;
//            }
//        }
//        return i;
//    }
    
    private int partition(int left, int right) {
        int pivot = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                pivot++;
                swap(i,pivot);
            }
        }
        swap(pivot, left);
        return pivot;
    }

    private void swap(int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
