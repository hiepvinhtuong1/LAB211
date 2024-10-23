/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomerManage {
    private final HashMap<String, ArrayList<Fruit>> hashTable;

    public CustomerManage() {
        hashTable = new HashMap<>();
    }
    
    public void addCusomter(String customerName, List<Fruit> orders) {
      hashTable.put(customerName, (ArrayList<Fruit>) orders);
    }
    
    public HashMap<String, ArrayList<Fruit>> getAll() {
        return hashTable;
    }
}
