package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/6/15
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreePrintBoundaries {


    public void printBorder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val + " ");
        printLeftBorder(node.left);
        printLeafNodes(node);
        printRightBorderReverse(node.right);
    }

    public void printLeftBorder(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null){
            if (root.right != null){
                System.out.print( root.val + " ");
                printLeftBorder(root.right);
            }
            return;
        }
        System.out.print( root.val + " ");
        printLeftBorder(root.left);
    }

    public void printRightBorderReverse(TreeNode root){
        if (root == null){
            return;
        }
        if (root.right == null){
            if (root.left != null){
                printRightBorderReverse(root.left);
                System.out.print( root.val + " ");
            }
            return;
        }
        printRightBorderReverse(root.right);
        System.out.print( root.val + " ");
    }

    public void printLeafNodes(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            System.out.print( root.val + " ");
            return;
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }


    public static void main(String[] args){
        BinaryTreePrintBoundaries b = new BinaryTreePrintBoundaries();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n6.left = n10;
        n6.right = n11;

//              1
//            /   \
//           2     3
//         / \   / \
//        4  5  6 7
//       / \   / \
//      8 9  10 11


        b.printBorder(n1);
        System.out.println();


        TreeNode n21 = new TreeNode(30);
        TreeNode n22 = new TreeNode(20);
        TreeNode n23 = new TreeNode(40);
        TreeNode n24 = new TreeNode(10);
        TreeNode n25 = new TreeNode(25);
        TreeNode n26 = new TreeNode(35);
        TreeNode n27 = new TreeNode(50);
        TreeNode n28 = new TreeNode(5);
        TreeNode n29 = new TreeNode(15);
        TreeNode n30 = new TreeNode(28);
        TreeNode n31 = new TreeNode(41);

        n21.left = n22;
        n21.right = n23;
        n22.left = n24;
        n22.right = n25;
        n23.left = n26;
        n23.right = n27;
        n24.left = n28;
        n24.right = n29;
        n25.right = n30;
        n27.right = n31;

//               30
//             /   \
//           20     40
//          / \    / \
//        10  25  35 50
//       / \   \     \
//      5 15  28     41

        b.printBorder(n21);
        System.out.println();
    }
}
