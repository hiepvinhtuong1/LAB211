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
public class PhoneBook {
    private ArrayList<Contact> contacts;
    private int quantity;
    
    /**
     * init Phonebook with quantity = 0 and contact;
     */
    public PhoneBook() {
        this.contacts = new ArrayList<>();
        this.quantity = 0;
    }
    
    /**
     * 
     * @param phone: phone of contact want to find
     * @return : contact include phone
     */
    public Contact getContactByPhone(String phone){
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)){
                return contact;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param id: id of contact want to find
     * @return : contact include id
     */
    public Contact getContactById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id){
                return contact;
            }
        }
        return null;
    }
    
    /**
     * 
     * @return : all contact in contacts
     */
    public List<Contact> getAllContact() {
        return new ArrayList<>(contacts);
    }
    
    /**
     * 
     * @param newContact: new contact need to add to contacts
     * @return : true if add done, false if phone is exist in phonebook
     */
    public boolean addContact(Contact newContact){
        if (getContactByPhone(newContact.getPhone()) != null) {
            System.out.println("Phone is exist in phonebook");
            return false;
        }
        String[] names = newContact.getFullName().split(" ", 2);
        String firstName = names[0];
        String lastName = names[1];
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);
        quantity++;
        newContact.setId(quantity);
        contacts.add(newContact);
        return true;
    }
    
    /**
     * 
     * @param id: id of contact want to delete
     * @return : true if delete done, false if id not exist in phonebook
     */
    public boolean deleteContact(int id) {
        if (getContactById(id) == null) {
            System.out.println("Id is not exist in phonebook");
            return false;
        }
        Contact contact = getContactById(id);
        contacts.remove(contact);
        return true;
    }
    
}
