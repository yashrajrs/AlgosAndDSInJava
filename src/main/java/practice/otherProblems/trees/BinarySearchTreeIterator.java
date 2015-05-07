package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * <p/>
 * Calling next() will return the next smallest number in the BST.
 * <p/>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * @author Yashraj R. Sontakke
 */
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return val;
    }


    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(80);
        TreeNode node2 = new TreeNode(73);
        TreeNode node3 = new TreeNode(78);
        TreeNode node4 = new TreeNode(60);
        TreeNode node5 = new TreeNode(85);
        TreeNode node6 = new TreeNode(90);

        node1.left = node2;
        node2.right = node3;
        node2.left = node4;
        node1.right = node5;
        node5.right = node6;

        BinarySearchTreeIterator b= new BinarySearchTreeIterator(node1);

        while (b.hasNext()){
            System.out.print(b.next() + " ");
        }
        System.out.println();


    }

}