/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import controller.StudentController;
import utils.StudentRule;
import utils.Validation;
import view.StudentView;
import model.StudentHandle;
import model.ReportHandle;

public class Main {

    public static void main(String[] args) {
        // Khởi tạo các dependencies cho StudentController
        StudentRule studentRule = new StudentRule();
        Validation validation = new Validation(studentRule);
        StudentHandle studentHandle = new StudentHandle();
        ReportHandle reportHandle = new ReportHandle();
        StudentView studentView = new StudentView();

        // Khởi tạo StudentController và truyền các dependencies vào
        StudentController studentController = new StudentController(validation, studentView, studentRule, reportHandle, studentHandle);

        // Chạy chương trình
        studentController.run();
    }
}
