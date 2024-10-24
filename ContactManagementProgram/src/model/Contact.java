/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */

// Lớp contact đại diện cho một liên hệ trong danh bạ
public class Contact {
    private int id;
    private String fullName;
    private String group;
    private String address;
    private String phone;
    private String firstName;
    private String lastName;
    
    // Constructor để khởi tạo liên hệ

    public Contact(int id, String fullName, String group, String address, String phone, String firstName, String lastName) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact(String fullName, String group, String address, String phone) {
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-20s %-20s %-20s %-20s %-20s %-20s", id,fullName, firstName, lastName,group, address, phone);
    }
    
    
}
