/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import model.FruitRepo;

/**
 *
 * @author Admin
 */
public class View {
    
   

    public void view() {
        FruitRepo fruitRepo = new FruitRepo();
        Controller controller = new Controller(fruitRepo);
        
        controller.run();
    }
}
