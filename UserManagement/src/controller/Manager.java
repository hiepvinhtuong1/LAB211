/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Admin
 */
public class Manager {

    private List<User> userList;

    public Manager() {
        userList = new ArrayList<>();
    }

    public void getListUser() {
        try {
            File f = new File("user.dat");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                String[] info = line.split(" ");
                userList.add(new User(info[0], info[1]));
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.err.println("Can't read file.");
        }
    }

    public void saveToFile() {
        try {
            File f = new File("user.dat");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (User user : userList) {
                bw.write(user.toString());
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void addAccount() {
        String username, password;
        getListUser();
        while (true) {
            try {
                username = Validation.checkUserName("Enter username: ", userList);
                password = Validation.checkPassword("Enter password: ");
                userList.add(new User(username, password));
                saveToFile();
                return;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public User find() {
        String username, password;
        getListUser();
        while (true) {
            try {
                username = Validation.checkUserName("Enter ", userList);
                password = Validation.checkPassword("Enter password: ");
                User checkUser = new User(username, password);
                if (userList.contains(checkUser)) {
                    return checkUser;
                } else {
                    return null;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
