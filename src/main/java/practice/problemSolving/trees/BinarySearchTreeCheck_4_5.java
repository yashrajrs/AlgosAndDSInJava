package practice.problemSolving.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * @author Yashraj R. Sontakke
 */
public class BinarySearchTreeCheck_4_5 {
    public static int LAST_PRINTED = Integer.MIN_VALUE;

    public static boolean checkBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!checkBST(node.getLeftChild())) {
            return false;
        }
        if (node.getData() <= LAST_PRINTED) {
            return false;
        }
        LAST_PRINTED = node.getData();

        if (!checkBST(node.getRightChild())) {
            return false;
        }

        return true;
    }

    public boolean checkTree(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.getData() <= min || node.getData() >= max) {
            return false;
        }
        if (!checkTree(node.getLeftChild(), min, node.getData()) ||
                !checkTree(node.getRightChild(), node.getData(), max)) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        BinarySearchTreeCheck_4_5 binarySearchTreeCheck = new BinarySearchTreeCheck_4_5();
        BinarySearchTree b = new BinarySearchTree();
        b.addData(50);
        b.addData(30);
        b.addData(70);
        b.addData(20);
        b.addData(40);
        b.addData(60);
        b.addData(80);

//        printCheck(BinarySearchTreeCheck_4_5.checkBST(b.parent));
//        printCheck(binarySearchTreeCheck.checkTree(b.parent, Integer.MIN_VALUE, Integer.MAX_VALUE));

        TreeNode node1 = new TreeNode(50);
        TreeNode node2 = new TreeNode(60);
        TreeNode node3 = new TreeNode(70);
        TreeNode node4 = new TreeNode(80);
        TreeNode node5 = new TreeNode(90);
        node3.setLeftChild(node1);
        node3.setRightChild(node4);
        node1.setLeftChild(node2);
        node1.setRightChild(node5);

//        printCheck(BinarySearchTreeCheck_4_5.checkBST(node3));
//        printCheck(binarySearchTreeCheck.checkTree(node3, Integer.MIN_VALUE, Integer.MAX_VALUE));


        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(1);
        node11.setLeftChild(node21);
        printCheck(binarySearchTreeCheck.checkTree(node11, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static void printCheck(boolean value) {
        if (value) {
            System.out.println("IS BINARY SEARCH TREE");
        } else {
            System.out.println("IS NOT BINARY SEARCH TREE");
        }
    }
}
