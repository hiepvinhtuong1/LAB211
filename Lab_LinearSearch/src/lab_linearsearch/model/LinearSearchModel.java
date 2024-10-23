/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_linearsearch.model;

/**
 *
 * @author Admin
 */
public class LinearSearchModel {
    
    private int[] array;

    public LinearSearchModel() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
    
     public int linearSearch(int searchNumber) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNumber) {
                return i;  // Trả về chỉ số khi tìm thấy giá trị
            }
        }
        return -1;  // Trả về -1 nếu không tìm thấy
    }
}
