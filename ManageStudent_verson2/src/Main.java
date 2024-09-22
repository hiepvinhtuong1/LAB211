/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import controller.StudentController;
import service.StudentRule;
import service.StudentService;
import utils.Validation;
import view.StudentView;
import model.StudentHandle;
import model.ReportHandle;
import service.ReportService;

public class Main {

    public static void main(String[] args) {
        // Khởi tạo các dependencies cho StudentController
        StudentRule studentRule = new StudentRule();
        Validation validation = new Validation(studentRule);
        StudentHandle studentHandle = new StudentHandle();
        ReportHandle reportHandle = new ReportHandle();
        StudentService studentService = new StudentService(studentHandle, validation, studentRule, reportHandle);
        StudentView studentView = new StudentView();
        ReportService reportService = new ReportService(reportHandle);

        // Khởi tạo StudentController và truyền các dependencies vào
        StudentController studentController = new StudentController(studentService, validation, studentView, studentRule, reportService);

        // Chạy chương trình
        studentController.run();
    }
}
