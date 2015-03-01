package practice.problemSolving.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

/**
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide ifT2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of
 * n is identical to T2. That is, if you cut off the tree at node n, the two trees would
 * be identical.
 *
 * @author Yashraj R. Sontakke
 */
public class SubSet_4_8 {

    public boolean subSet(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        TreeNode node1 = binarySearch(root1, root2.getData());
        if (node1 == null) {
            return false;
        }

        return isSubSet(node1, root2);
    }

    public boolean isSubSet(TreeNode node1, TreeNode node2) {
        if ((node1 == null && node2 != null) ||
                (node1 != null && node2 == null)) {
            return false;
        } else if (node1 == null && node2 == null) {
            return true;
        }
        if (!isSubSet(node1.getLeftChild(), node2.getLeftChild())) {
            return false;
        }
        if (node1.getData() != node2.getData()) {
            return false;
        }
        return isSubSet(node1.getRightChild(), node2.getRightChild());
    }


    public TreeNode binarySearch(TreeNode root, Integer data) {
        if (root == null || root.getData() == data) {
            return root;
        } else if (root.getData() > data) {
            return binarySearch(root.getLeftChild(), data);
        } else {
            return binarySearch(root.getRightChild(), data);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.addData(80);
        b.addData(73);
        b.addData(78);
        b.addData(60);
        b.addData(85);
        b.addData(90);
        b.addData(83);
        b.addData(87);
        b.addData(95);
        b.addData(93);
        b.addData(99);

        BinarySearchTree c = new BinarySearchTree();
        c.addData(90);
        c.addData(87);
        c.addData(95);
        c.addData(93);
        c.addData(99);

        SubSet_4_8 subSet = new SubSet_4_8();
        System.out.println(subSet.subSet(b.parent, c.parent));

        c.addData(100);
        System.out.println(subSet.subSet(b.parent, c.parent));

    }
}
