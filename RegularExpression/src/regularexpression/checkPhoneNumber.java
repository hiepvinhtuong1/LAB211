/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regularexpression;

/**
 *
 * @author Admin
 */
public class checkPhoneNumber {

    private String phone;

    public checkPhoneNumber() {
    }

    public checkPhoneNumber(String phone) {
        this.phone = phone;
    }

    public void checkPhone(String phone) {
        if (phone.matches("^[0-9]{10}")
            || phone.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")
            || phone.matches("^[0-9]{3}.[0-9]{3}.[0-9]{4}$")
            || phone.matches("^[0-9]{3} [0-9]{3} [0-9]{4}$")
            || phone.matches("^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$")
            || phone.matches("^[0-9]{3} [0-9]{3} [0-9]{4} (x|ext)[0-9]{4}$")) {
            System.out.println("phone is oke");
        } else {
            System.out.println("phone is not oke");
        }
    }
}
