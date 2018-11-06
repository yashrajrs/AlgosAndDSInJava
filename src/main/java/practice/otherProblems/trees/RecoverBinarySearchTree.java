package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 7/4/15
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class RecoverBinarySearchTree {
    TreeNode node1 = null;
    TreeNode node2 = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        helper(root);
        if (node1 !=null && node2 != null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(pre !=null && pre.val > root.val){
            if (node1 == null){
                node1 = pre;
            }
            node2 = root;
        }
        pre = root;


        helper(root.right);
    }


    public static void main(String[] args){
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(9);

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


        //          7
        //         /  \
        //       3     9
        //      / \   / \
        //     1  5  10   8

        r.recoverTree(n1);

        r.printInorder(n1);
    }

    public void printInorder(TreeNode node){
        if (node == null){
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
