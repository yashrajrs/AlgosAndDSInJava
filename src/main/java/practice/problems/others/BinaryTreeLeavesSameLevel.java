package practice.problems.others;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

/**
 * Check if all the leaves are at the same level in a binary tree.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeLeavesSameLevel {

    public int checkLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkLevel(node.getLeftChild());
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkLevel(node.getRightChild());
        if (rightHeight == -1) {
            return -1;
        }

        if (leftHeight != rightHeight) {
            return -1;
        }
        return leftHeight + 1;
    }

    public void isBalanced(TreeNode n) {
        if (checkLevel(n) != -1) {
            System.out.println("Leaves are on same level");
        } else {
            System.out.println("Leaves are not same level");
        }
    }

    public static void main(String[] args) {
        BinaryTreeLeavesSameLevel binaryTreeLeavesSameLevel = new BinaryTreeLeavesSameLevel();
        BinarySearchTree b = new BinarySearchTree();
        b.addData(50);
        b.addData(30);
        b.addData(70);
        b.addData(20);
        b.addData(40);
        b.addData(60);
        b.addData(80);
        binaryTreeLeavesSameLevel.isBalanced(b.parent);

        b.addData(10);
        binaryTreeLeavesSameLevel.isBalanced(b.parent);
    }
}
