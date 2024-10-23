/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_linearsearch;

import lab_linearsearch.controller.LinearSearchController;
import lab_linearsearch.model.LinearSearchModel;
import lab_linearsearch.view.LinearSearchView;

/**
 *
 * @author Admin
 */
public class Lab_LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinearSearchModel model = new LinearSearchModel();
        LinearSearchView view = new LinearSearchView();
        LinearSearchController controller = new LinearSearchController(model, view);
        
        controller.run();
    }
    
}
