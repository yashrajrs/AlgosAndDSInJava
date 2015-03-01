package practice.problemSolving.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

/**
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree. You may assume that each node has a link to its parent.
 *
 * @author Yashraj R. Sontakke
 */
public class InOrderSuccessor_4_6 {

    public TreeNode getInOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.getRightChild() != null) {
            return findMinimum(node.getRightChild());
        } else {
            TreeNode q = node;
            TreeNode parent = node.getParent();

            while (parent != null && parent.getLeftChild() != q) {
                q = parent;
                parent = parent.getParent();
            }
            return parent;
        }
    }

    public TreeNode findMinimum(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    public static void main(String[] args) {
        InOrderSuccessor_4_6 inOrderSuccessor = new InOrderSuccessor_4_6();
        BinarySearchTree b = new BinarySearchTree();
        b.addData(50);
        b.addData(30);
        b.addData(70);
        b.addData(20);
        b.addData(40);
        b.addData(60);
        b.addData(80);
        System.out.println(inOrderSuccessor.getInOrderSuccessor(b.parent));
        System.out.println(inOrderSuccessor.getInOrderSuccessor(b.parent.getLeftChild().getRightChild()));
        System.out.println(inOrderSuccessor.getInOrderSuccessor(b.parent.getRightChild().getRightChild()));

    }
}
