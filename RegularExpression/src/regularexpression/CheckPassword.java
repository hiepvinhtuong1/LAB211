/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regularexpression;

import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class CheckPassword {

    private String password;

    public CheckPassword() {
    }

    public CheckPassword(String password) {
        this.password = password;
    }

    public void check(String password) {
        Pattern pUpper = Pattern.compile("^.*[A-Z]+.*$");
        Pattern pLower = Pattern.compile("^.*[a-z]+.*$");
        Pattern pDigit = Pattern.compile("^.*[0-9]+.*$");
        Pattern pSpecial = Pattern.compile("^.*[#?!@$%^&*-+]+.*$");
        Pattern pLength = Pattern.compile("^.{8,}$");
        
        if (pUpper.matcher(password).find() &&
            pLower.matcher(password).find() &&
            pDigit.matcher(password).find() &&
            pSpecial.matcher(password).find() &&
            pLength.matcher(password).find()) {
            System.out.println("oke");
        } else {
            System.out.println("password is not oke");
        }
    }
}
