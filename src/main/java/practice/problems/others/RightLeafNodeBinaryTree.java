package practice.problems.others;

import practice.dataStructures.trees.TreeNode;

/**
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down
 * and turn it into a tree with left leaf nodes.

 * Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.


 * for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1

 *
 * @author Yashraj R. Sontakke
 */
public class RightLeafNodeBinaryTree {

    public TreeNode flipNode(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.getLeftChild()==null  && root.getRightChild()==null){
            return root;
        }

        TreeNode newRoot = flipNode(root.getLeftChild());
        root.getLeftChild().setLeftChild(root.getRightChild());
        root.getLeftChild().setRightChild(root);
        root.setLeftChild(null);
        root.setRightChild(null);
        return newRoot;

    }

    public static void main(String[] args){
        RightLeafNodeBinaryTree r = new RightLeafNodeBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.setLeftChild(node2);
        node1.setRightChild(node3);

        node2.setLeftChild(node4);
        node2.setRightChild(node5);

        node4.setLeftChild(node6);
        node4.setRightChild(node7);

        TreeNode node = r.flipNode(node1);

        System.out.println();
    }
}
