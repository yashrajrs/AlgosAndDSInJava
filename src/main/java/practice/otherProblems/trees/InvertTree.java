package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.LinkedList;

/**
 * Invert a binary tree.

 Example:

 Input:

      4
    /   \
   2     7
  / \   / \
 1   3 6   9
 Output:

      4
    /   \
   7     2
  / \   / \
 9   6 3   1
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;
            node.left = rightChild;
            node.right = leftChild;
            if (leftChild != null) {
                queue.add(leftChild);
            }
            if(rightChild != null) {
                queue.add(rightChild);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        invertTree.printInOrder(node1);

        System.out.println();
        TreeNode result = invertTree.invertTree(node1);
        invertTree.printInOrder(result);
    }

    public void printInOrder(final TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }
}
