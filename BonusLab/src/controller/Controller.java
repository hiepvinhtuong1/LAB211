/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.LinkedList;
import model.Node;

/**
 *
 * @author Admin
 */
public class Controller {

    Scanner sc = new Scanner(System.in);
    LinkedList linkedList = new LinkedList();
    Validate validate = new Validate();

    public void showMenu() {
        System.out.println("=====Menu=====");
        System.out.println("1. Create SingleLinkedList");
        System.out.println("2.Bubble Sort");
        System.out.println("3.Selection Sort");
        System.out.println("4.Insertion Sort");
        System.out.println("5.Exit");
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = validate.validateInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    System.out.println("-------- Create SingleLinkedList --------");
                    linkedList.inputLL();
                    break;
                case 2:
                    if (linkedList.getLength() == 0) {
                        System.out.println("Bubble Sort");
                    } else {
                        bubbleSort();
                    }
                    break;
                case 3:
                    if (linkedList.getLength() == 0) {
                        System.out.println("You must create SingleLinkedList");
                    } else {
                        selectionSort();
                    }
                    break;
                case 4:
                    if (linkedList.getLength() == 0) {
                        System.out.println("You must create SingleLinkedList");
                    } else {
                        insertSort();
                    }
                    break;
                case 5:
                    System.out.println("Exit succesfully");
                    return; // Exit the program
            }
        }
    }

    public void bubbleSort() {
        LinkedList linkedList1 = new LinkedList();
        Node temp = linkedList.getHead();
        while (temp != null) {
            linkedList1.append(temp.value);
            temp = temp.next;
        }

        linkedList1.printList();
        for (int i = 0; i < linkedList1.getLength() - 1; i++) {
            Node current = linkedList1.getHead();
            for (int j = 0; j < linkedList1.getLength() - i - 1; j++) {
                if (current.value > current.next.value) {
                    int save = current.value;
                    current.value = current.next.value;
                    current.next.value = save;
                    linkedList1.printList();
                }
                current = current.next;
            }
        }
    }

    public void selectionSort() {

        LinkedList linkedList1 = new LinkedList();
        Node temp = linkedList.getHead();
        while (temp != null) {
            linkedList1.append(temp.value);
            temp = temp.next;
        }

        linkedList1.printList();
        for (Node current = linkedList1.getHead(); current != null; current = current.next) {
            Node min = current;  // Giả định current là nhỏ nhất
            for (Node next = current.next; next != null; next = next.next) {
                if (next.value < min.value) {
                    min = next;
                }
            }
            if (min != current) {
                int save = current.value;
                current.value = min.value;
                min.value = save;
            }
            linkedList1.printList();
        }
    }

    public void insertSort() {

        LinkedList linkedList1 = new LinkedList();
        Node temp = linkedList.getHead();
        while (temp != null) {
            linkedList1.append(temp.value);
            temp = temp.next;
        }
        linkedList1.printList();
     
        for (int i = 1; i < linkedList1.getLength(); ++i) {
           
            int key = linkedList1.get(i).value;
            int j = i - 1;
            while (j >= 0 && linkedList1.get(j).value > key) {
                linkedList1.get(j + 1).value = linkedList1.get(j).value;
                j -= 1;
            }
            linkedList1.get(j + 1).value = key;
            linkedList1.printList();
        }
    }
}
