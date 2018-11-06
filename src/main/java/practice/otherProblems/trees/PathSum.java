package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:

 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6
 Example 2:

 Input: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
   /  \
  15   7

 Output: 42
 */
public class PathSum {
    public int maxPathSum(TreeNode root) {
        int max[]  = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public int calculateSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.val, Math.max(root.val+left, root.val + right));
        max[0] = Math.max(max[0], Math.max(current, root.val + left + right));
        return current;
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        TreeNode node11 = new TreeNode(-10);
        TreeNode node12 = new TreeNode(9);
        TreeNode node13 = new TreeNode(20);
        TreeNode node14 = new TreeNode(15);
        TreeNode node15 = new TreeNode(7);


        node11.left = node12;
        node11.right = node13;
        node13.left = node14;
        node13.right = node15;


        System.out.println(pathSum.maxPathSum(node1));
        System.out.println(pathSum.maxPathSum(node11));
    }
}
