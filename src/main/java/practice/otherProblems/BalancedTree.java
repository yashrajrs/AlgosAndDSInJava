package practice.otherProblems;

import practice.dataStructures.trees.BinarySearchTree;

/**
 * Given a binary tree, determine if it is height-balanced.

 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 * @author Yashraj R. Sontakke
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(getHeight(root) == -1){
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if(rightHeight == -1){
            return -1;
        }
        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1){
            return -1;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        BalancedTree balancedTreeCheck_4_1 = new BalancedTree();

        TreeNode node1 = new TreeNode(50);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(70);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(40);
        TreeNode node6 = new TreeNode(60);
        TreeNode node7 = new TreeNode(80);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(balancedTreeCheck_4_1.isBalanced(node1));

        node1.right = null;
        System.out.println(balancedTreeCheck_4_1.isBalanced(node1));
    }
}
