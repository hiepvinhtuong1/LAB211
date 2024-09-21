/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Person implements Comparable<Person>{
    private String name;
    private String address;
    private double money;

    public Person(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String toString(int mode) {
        if (mode == 1) return String.format("%-20s%-20s%-20.1f",name,address,money);
        if (mode == 2) return name+";"+address+";"+money +"\n";
        return null;
    }
    
    @Override
    public int compareTo(Person other) {
        // Define comparison logic (e.g., compare by age)
        return Double.compare(this.money, other.money);
    }
}
