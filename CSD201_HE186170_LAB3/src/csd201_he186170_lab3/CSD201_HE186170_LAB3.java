/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csd201_he186170_lab3;

import java.util.List;

/**
 *
 * @author Admin
 */
public class CSD201_HE186170_LAB3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // insert các giá trị vào cây
        RecursionBinarySearchTree rBST = new RecursionBinarySearchTree();
        rBST.rBST_Insert(0);
        rBST.rBST_Insert(1);
        rBST.rBST_Insert(2);
        rBST.rBST_Insert(3);
        
        // nếu giá trị trùng báo lỗi
        if (rBST.rBST_Insert(3) == false) System.out.println("Giá trị này đã tồn tại");
        
        // contain
         System.out.println(rBST.rBST_Contain(1));
         
        //delete
        System.out.println(rBST.rBST_Delete(2));
        
        // in ra cây theo kiểu inorder
        rBST.rBST_inOrder();
    }

}
