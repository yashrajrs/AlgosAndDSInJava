package practice.problems.trees;

import practice.dataStructures.trees.TreeNode;

/**
 * Check if the given binary tree is a unival tree. (all nodes have same value)
 * <p/>
 * Follow up- Count the number of unival subtrees in a binary tree.
 *
 * @author Yashraj R. Sontakke
 */
public class UnivalTree {

    public boolean isUnivalTree(TreeNode node, int data) {
        if (node == null) {
            return true;
        }
        if (!isUnivalTree(node.getLeftChild(), data)) {
            return false;
        }
        if (node.getData() != data) {
            return false;
        }
        return isUnivalTree(node.getRightChild(), data);
    }

    public int countUnivalTrees(TreeNode node, Integer data) {
        if (node == null) {
            return 0;
        }
        if (data == null || node.getData() == data) {
            return countUnivalTrees(node.getLeftChild(), node.getData()) + countUnivalTrees(node.getRightChild(), node.getData());
        }

        return 1 + countUnivalTrees(node.getLeftChild(), node.getData()) + countUnivalTrees(node.getRightChild(), node.getData());
    }

    public static void main(String[] main) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);

        node1.setLeftChild(node2);
        node1.setRightChild(node3);

        node2.setLeftChild(node4);
        node2.setRightChild(node5);

        node3.setLeftChild(node6);
        node3.setRightChild(node7);

        UnivalTree univalTree = new UnivalTree();
        System.out.println(univalTree.isUnivalTree(node1, node1.getData()));

        System.out.println(univalTree.countUnivalTrees(node1, Integer.MIN_VALUE));

        node7.setLeftChild(new TreeNode(2));
        System.out.println(univalTree.isUnivalTree(node1, node1.getData()));


        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(2);
        TreeNode node15 = new TreeNode(2);
        TreeNode node16 = new TreeNode(3);
        TreeNode node17 = new TreeNode(3);
        TreeNode node18 = new TreeNode(5);
        TreeNode node19 = new TreeNode(5);
        TreeNode node20 = new TreeNode(4);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(3);
        TreeNode node23 = new TreeNode(3);

        node11.setLeftChild(node12);
        node11.setRightChild(node13);

        node12.setLeftChild(node14);
        node12.setRightChild(node15);

        node13.setLeftChild(node16);
        node13.setRightChild(node17);

        node14.setLeftChild(node18);
        node14.setRightChild(node19);

        node16.setLeftChild(node20);
        node16.setRightChild(node21);

        node17.setLeftChild(node22);
        node17.setRightChild(node23);

        System.out.println(univalTree.countUnivalTrees(node11, Integer.MIN_VALUE));
    }
}
