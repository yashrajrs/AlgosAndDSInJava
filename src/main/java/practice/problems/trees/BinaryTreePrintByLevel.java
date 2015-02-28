package practice.problems.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;

/**
 * Print binary tree such that nodes at a particular level are on the same level
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreePrintByLevel {

    public void print(TreeNode input) {
        ArrayList<TreeNode> elements = new ArrayList<TreeNode>();

        TreeNode n = input;

        System.out.println(n.getData());
        elements.add(n.getLeftChild());
        elements.add(n.getRightChild());
        elements.add(new TreeNode(-1));

        while (!elements.isEmpty()) {
            TreeNode node = elements.remove(0);
            if (node.getData() != -1) {
                System.out.print(node.getData());
                if (node.getLeftChild() != null) {
                    elements.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    elements.add(node.getRightChild());
                }
                System.out.print(" ");
            } else if (node.getData() == -1 && elements.isEmpty()) {
                return;
            } else {

                System.out.println();
                elements.add(new TreeNode(-1));
            }
        }
    }


    public static void main(String[] args) {
        BinaryTreePrintByLevel a = new BinaryTreePrintByLevel();
        BinarySearchTree b = new BinarySearchTree();
        b.addData(5);
        b.addData(3);
        b.addData(7);
        b.addData(2);
        b.addData(4);
        b.addData(6);
        b.addData(9);

        System.out.println();
        a.print(b.parent);
    }
}
