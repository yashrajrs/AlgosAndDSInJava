package practice.otherProblems.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.otherProblems.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 * Assume a BST is defined as follows:

 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * @author Yashraj R. Sontakke
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        if(! validate(root.left, min, root.val) ){
            return false;
        }
        return validate(root.right, root.val, max);

    }

    public static void main(String[] args){
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();

        TreeNode n1 = new TreeNode(50);
        TreeNode n2 = new TreeNode(30);
        TreeNode n3 = new TreeNode(70);
        TreeNode n4 = new TreeNode(20);
        TreeNode n5 = new TreeNode(40);
        TreeNode n6 = new TreeNode(60);
        TreeNode n7 = new TreeNode(80);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        printCheck(v.isValidBST(n1));


        TreeNode node11 = new TreeNode(50);
        TreeNode node12 = new TreeNode(60);
        TreeNode node13 = new TreeNode(70);
        TreeNode node14 = new TreeNode(80);
        TreeNode node15 = new TreeNode(90);

        node13.left = node11;
        node13.right = node14;
        node11.left = node12;
        node11.right = node15;

        printCheck(v.isValidBST(node13));
    }

    private static void printCheck(boolean value) {
        if (value) {
            System.out.println("IS BINARY SEARCH TREE");
        } else {
            System.out.println("IS NOT BINARY SEARCH TREE");
        }
    }
}
