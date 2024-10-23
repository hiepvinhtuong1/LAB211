/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.CustomerManage;
import model.Fruit;
import model.FruitRepo;

/**
 *
 * @author Admin
 */
public class Controller {

    private Scanner sc = new Scanner(System.in);
    private final FruitRepo fruitRepo;
    private final CustomerManage customerManage;

    public Controller(FruitRepo fruitRepo, CustomerManage customerManage) {
        this.fruitRepo = fruitRepo;
        this.customerManage = customerManage;
    }

    public void showMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit");
        System.out.println(" (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
    }

    public void run() {
        while (true) {
            showMenu();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
            }
        }
    }

    public void createFruit() {
        String id, name, orgin;
        double price;
        int quantity;

        try {
            System.out.print("Id: ");
            id = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Orgin: ");
            orgin = sc.nextLine();
            System.out.print("Price: ");
            price = sc.nextDouble();
            System.out.print("Quantity: ");
            quantity = sc.nextInt();

            Fruit newFruit = new Fruit(id, name, price, quantity, orgin);

            if (fruitRepo.checkValidFruitCreate(newFruit) == 1) {
                fruitRepo.addFruit(newFruit);
            } else if (fruitRepo.checkValidFruitCreate(newFruit) == 2) {
                Fruit fruitInRepo = fruitRepo.getFruitById(newFruit.getId());
                fruitInRepo.setQuanity(fruitInRepo.getQuanity() + newFruit.getQuanity());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void shopping() {
        List<Fruit> orders = new ArrayList<>();
        while (true) {

            // display list of fruit
            List<Fruit> listOfFruit = fruitRepo.getAllFruit();
            System.out.println("List of fruit: ");
            for (Fruit fruit : listOfFruit) {
                System.out.println(fruit.toString());
            }

            // let customer select fruit by id
            System.out.println("Please select an item by id: ");
            String selectedItemId = sc.nextLine();

            // get fruit by selectedItemId
            Fruit selectedFruit = fruitRepo.getFruitById(selectedItemId);

            if (selectedFruit != null) {
                System.out.println("You selected " + selectedFruit.getName());
                System.out.print("Please input quantity: ");
                int quantity = sc.nextInt();

                Fruit fruitOrder = new Fruit();
                fruitOrder.setId(selectedFruit.getId());
                fruitOrder.setName(selectedFruit.getName());
                fruitOrder.setOrigin(selectedFruit.getOrigin());
                fruitOrder.setPrice(selectedFruit.getPrice());
                fruitOrder.setQuanity(quantity);

                orders.add(fruitOrder);

                System.out.println("Do you want to order nơ (Y/N)");
                String orderNow = sc.nextLine();

                if (orderNow.equalsIgnoreCase("Y")) {
                    int total = 0;

                    System.out.println("Product | Quantity | Price | Amount");
                    for (Fruit order : orders) {
                        double amount = order.getPrice() * order.getQuanity();
                        System.out.println(order.getName() + " | " + order.getQuanity() + " | " + order.getPrice() + "$ | " + amount + "$");
                        total += amount;
                    }
                    System.out.println("Total: " + total + "$");

                    // Input customer naem
                    String customerName = sc.nextLine();

                    for (Map.Entry<String, ArrayList<Fruit>> entry : customerManage.getAll().entrySet()) {
                        String customerName1 = entry.getKey();
                        if (customerName1.equalsIgnoreCase(customerName)) {
                            System.out.println("Do you want to update your order");
                        }
                    }
                    customerManage.addCusomter(customerName, orders);
                }
            }
        }
    }
}
