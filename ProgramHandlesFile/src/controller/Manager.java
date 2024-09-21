/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import model.Person;

/**
 *
 * @author Admin
 */
public class Manager {

    private List<Person> pList;

    public Manager() {
        pList = new ArrayList<>();
    }

    //Đọc dữ liệu từ file và add vào pList
    public void getListPerson(String pathFile) {
        try {
            File f = new File(pathFile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split(";");
                String name = info[0].trim();
                String address = info[1].trim();
                Double money = Validation.getDouble(info[2].trim());
                pList.add(new Person(name, address, money));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.err.println("Can't read file.");
        }
    }

    public void findPersonInfo() {
        System.out.println("--------- Person Info ----------");
        String pathFIle = Validation.checkInputPathFile("Enter Path: ");
        double money = Validation.checkInputMoney("Enter money: ");
        getListPerson(pathFIle);
        if (pList.isEmpty()) {
            System.out.println("NOTHING TO FIND");
            return;
        }
        System.out.println("--------- Result ----------");
        printListPerson(money);
    }

    public void printListPerson(double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        Collections.sort(pList);
        for (Person person : pList) {
            if (person.getMoney() >= money) {
                System.out.println(person.toString(1));
            }
        }
        System.out.println("Min: " + pList.get(0).getName());
        System.out.println("Max: " + pList.get(pList.size() - 1).getName());
    }

    public void coppyNewFile() {
        System.out.println("--------- Copy text ----------");
        String sourceFile = Validation.checkInputPathFile("Enter Source: ");
        String newFile = Validation.checkInputPathFile("Enter new file name: ");
        String content = getNewContent(sourceFile);
        writeNewContent(newFile, content);
    }

    public String getNewContent(String pathFile) {
        HashSet<String> newContent = new HashSet<>();
        File file = new File(pathFile);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word + " ");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }
        String content = "";
        for (String line : newContent) {
            content += line;
        }
        return content;
    }

    public void writeNewContent(String pathFile, String content) {
        File f = new File(pathFile);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
            System.out.println("Write successfull");
        } catch (Exception e) {
            System.err.println("Can’t write file");
        }
    }
}
