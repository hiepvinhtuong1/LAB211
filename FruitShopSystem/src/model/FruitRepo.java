/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FruitRepo {
    private final List<Fruit> fruitRepo;

    public FruitRepo() {
        fruitRepo = new ArrayList<>();
    }
    
    public List<Fruit> getAllFruit() {
        return fruitRepo;
    }
    
    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruitRepo) {
            if (fruit.getId().equals(id)){
                return fruit;
            }
        }
        return null;
    }
    
    public void addFruit(Fruit fruit) {
        fruitRepo.add(fruit);
    }
    public List<Fruit> getListFruitById(String id) {
        List<Fruit> listFruitById = new ArrayList<>();
        for (Fruit fruit : fruitRepo) {
            if (fruit.getId().equals(id)) {
                listFruitById.add(fruit);
            }
        }
        return listFruitById;
    }
    
    public int checkValidFruitCreate(Fruit newFruit) throws Exception {
        Fruit fruitInRepo = getFruitById(newFruit.getId());
        
        if (fruitInRepo == null) {
            return 1;
        }
        if (newFruit.getName().equals(fruitInRepo.getName())
                && newFruit.getPrice() == fruitInRepo.getPrice()
                && newFruit.getOrigin().equals(fruitInRepo.getOrigin())) {
            return 2;
        } else {
            throw new IllegalArgumentException("Error create: Id is exist!!!");
        }        
    }  
}
