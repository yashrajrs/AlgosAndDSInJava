package practice.problemSolving.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one
 *
 * @author Yashraj R. Sontakke
 */
public class BalancedTreeCheck_4_1 {

    public Integer checkHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }

        Integer leftHeight = checkHeight(n.getLeftChild());
        if (leftHeight == -1) {
            return -1;
        }

        Integer rightHeight = checkHeight(n.getRightChild());
        if (rightHeight == -1) {
            return -1;
        }

        Integer heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void isBalanced(TreeNode n) {
        if (checkHeight(n) != -1) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }

    public static void main(String[] args) {
        BalancedTreeCheck_4_1 balancedTreeCheck_4_1 = new BalancedTreeCheck_4_1();
        BinarySearchTree b = new BinarySearchTree();
        b.addData(50);
        b.addData(30);
        b.addData(70);
        b.addData(20);
        b.addData(40);
        b.addData(60);
        b.addData(80);
        balancedTreeCheck_4_1.isBalanced(b.parent);
    }
}
