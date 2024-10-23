/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_quicksort.model;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class MergeSortModel {

    private int array[];

    public MergeSortModel() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private void merge(int left, int mid, int right) {

        int length1 = mid - left + 1;
        int length2 = right - mid;

        int[] leftArray = new int[length1];
        int[] rightArray = new int[length2];

        for (int i = 0; i < length1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < length2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < length1 && j < length2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy các phần tử còn lại
        while (i < length1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < length2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

    public void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, right);
        }
    }
}
