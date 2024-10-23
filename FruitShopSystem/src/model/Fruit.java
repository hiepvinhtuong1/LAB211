/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Fruit {
    
    // define fields of Fruit
    private String id;
    private String name;
    private double price;
    private int quanity;
    private String origin;
    
    // define contrucstor

    public Fruit() {
    }
    
    
    public Fruit(String id, String name, double price, int quanity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quanity = quanity;
        this.origin = origin;
    }
    
    // define getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    
}
