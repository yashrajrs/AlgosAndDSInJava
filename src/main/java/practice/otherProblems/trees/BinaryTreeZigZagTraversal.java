package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * <p/>
 * return its zigzag level order traversal as:
 * [ [3], [20,9], [15,7] ]
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int len;
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove(0);
                if (currentLevel % 2 == 0) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            currentLevel++;
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigZagTraversal b = new BinaryTreeZigZagTraversal();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;


        node3.left = node4;
        node3.right = node5;

        System.out.println(b.zigzagLevelOrder(node1).toString());

        node1.left = null;
        System.out.println(b.zigzagLevelOrder(node1).toString());
    }
}
