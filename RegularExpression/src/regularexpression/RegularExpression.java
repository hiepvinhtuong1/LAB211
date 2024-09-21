/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package regularexpression;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class RegularExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ví dụ chỉ nhận 1 số
//        Pattern p = Pattern.compile("^[0-9]$");
        //ví dụ nhập nhiều số
//        Pattern p = Pattern.compile("^[0-9]+$");
        //Ví dụ nhập mã code có nhiều hơn 6 kí tự
//        Pattern p = Pattern.compile("^[0-9]{6,}$");
        //ví dụ nhập mã code trong khoảng bao nhiêu kí tự
//        Pattern p = Pattern.compile("^[0-9]{6,10}$");
        //Ví dụ đầu vào là chữ
//        Pattern p = Pattern.compile("^[a-zA-Z]$");
    
    checkPhoneNumber check = new checkPhoneNumber();
    CheckPassword checkPassword = new CheckPassword();
    String txt;
    txt = sc.nextLine();
    //check.checkPhone(txt);
    checkPassword.check(txt);
    }
}
