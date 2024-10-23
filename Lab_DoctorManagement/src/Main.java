
import controller.DoctorController;
import model.ManagementDoctor;
import utils.Validation;
import view.DoctorView;

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
        DoctorView view = new DoctorView();
        Validation validation = new Validation();
        ManagementDoctor management = new ManagementDoctor();
        DoctorController controller = new DoctorController(view, management, validation);
        controller.start();
    }
}
