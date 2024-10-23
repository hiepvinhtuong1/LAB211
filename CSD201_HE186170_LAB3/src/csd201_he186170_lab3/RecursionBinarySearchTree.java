/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csd201_he186170_lab3;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RecursionBinarySearchTree {

    public class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node root;

    public RecursionBinarySearchTree() {
        root = null;
    }

    public boolean rBST_Insert(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        return insertRec(root, value);
    }

    private boolean insertRec(Node currentNode, int value) {
        if (value == currentNode.value) {
            return false;
        }
        if (value < currentNode.value) {
            if (currentNode.left == null) {
                currentNode.left = new Node(value);
                return true;
            }
            return insertRec(currentNode.left, value);
        } else {
            if (currentNode.right == null) {
                currentNode.right = new Node(value);
                return true;
            }
            return insertRec(currentNode.right, value);
        }
    }

    public boolean rBST_Contain(int value) {
        if (root == null) {
            return false;
        }
        return containRec(root, value);
    }

    public boolean containRec(Node currentNode, int value) {
        if (currentNode != null) {
            if (value == currentNode.value) {
                return true;
            }
            if (value < currentNode.value) {
                return containRec(currentNode.left, value);
            } else if (value > currentNode.value) {
                return containRec(currentNode.right, value);
            }
        }
        return false;
    }

    public boolean rBST_Delete(int value) {
        if (root == null) {
            return false;
        }
        return deleteRec(null, root, value);
    }

    public boolean deleteRec(Node parent, Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (value < currentNode.value) {
            return deleteRec(currentNode, currentNode.left, value);
        } else if (value > currentNode.value) {
            return deleteRec(currentNode, currentNode.right, value);
        } else {
            // Trường hợp 1: Node không có con hoặc chỉ có một con
            if (currentNode.left == null || currentNode.right == null) {
                Node child = (currentNode.left != null) ? currentNode.left : currentNode.right;

                if (parent == null) {
                    root = child;
                } else if (parent.left == currentNode) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                return true;
            }

            // Trường hợp 2: Node có hai con
            currentNode.value = minValue(currentNode.right);
            return deleteRec(currentNode, currentNode.right, currentNode.value);
        }
    }

    public int minValue(Node node) {
        int minVal = node.value;
        while (node.left != null) {
            minVal = node.left.value;
            node = node.left;
        }
        return minVal;
    }

    public void rBST_inOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {

            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        System.out.println("Print out the binary tree:");
        for (Integer result : results) {
            System.out.println(result + " ");
        }
    }
}
