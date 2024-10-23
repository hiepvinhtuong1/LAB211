/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LinkedList {

    Scanner sc = new Scanner(System.in);
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        length = 0;
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            tail = null;
            head = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirstNode() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    public boolean set(int index, int value) {

        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirstNode();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;

    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void inputLL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values for the linked list (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                append(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
            }
        }
    }

    public void removeDuplicate() {
        int index = -1;
        while (index < length - 2) {

            index++;
            Node currentNode = get(index);

            int j = index;
            while (j < length - 1) {
                j++;
                Node useNode = get(j);
                System.out.println(useNode.value);
                if (currentNode.value == useNode.value) {
                    remove(j);
                    j = j - 1;
                }
            }
        }
    }

    public void reverseBetween(int m, int n) {
        if (m < 0 || n < 0 || m > n || n >= length) {
            System.out.println("Dữ liệu đầu vào không đúng");
            return;
        }

        if (m == n) {
            return;
        }

        // Nếu m = 0 và n = length - 1, đảo ngược toàn bộ danh sách
        if (m == 0 && n == length - 1) {
            reverse();
            return;
        }

        // Lấy nút tại vị trí m và n
        Node headReverse = get(m);  // Nút tại vị trí m
        Node tailReverse = get(n);  // Nút tại vị trí n

        // Nút trước vị trí m
        Node beforeM = null;
        if (m > 0) {
            beforeM = get(m - 1); // Lấy nút ngay trước vị trí m nếu m > 0
        }

        // Nút sau vị trí n
        Node afterN = tailReverse.next;

        // Đảo ngược đoạn từ m đến n
        Node temp = headReverse;
        Node after = null;
        Node before = null;

        for (int i = m; i <= n; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        // Kết nối lại phần đã đảo ngược với phần còn lại của danh sách
        if (beforeM != null) {
            beforeM.next = before;
        } else {
            head = before;
        }

        headReverse.next = afterN;
    }

    public void swap() {
        if (head == null || head == tail) {
            return;
        }
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void merge(LinkedList other) {
        if (other.head == null) {
            return;
        }
        if (this.head == null) {
            this.head = other.head;
            this.tail = other.tail;
        } else {
            this.tail.next = other.head;
            this.tail = other.tail;
        }
        this.length += other.length;
    }
}
