
import controller.Controller;
import model.PhoneBook;
import utils.Validation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        PhoneBook phoneBook = new PhoneBook();
        Controller controller = new Controller(validation, phoneBook);

        // Chạy chương trình
        controller.run();
    }
}
