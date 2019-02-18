package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:

 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 Example:

 Input: root = [4,2,5,1,3], target = 3.714286

 4
 / \
 2   5
 / \
 1   3

 Output: 4
 */
public class ClosestBinarySearchTree {
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int result = root.val;

        while (root!=null) {
            if (target > root.val) {
                double diff = Math.abs(root.val - target);
                if (diff < min) {
                    min = Math.min(diff, min);
                    result = root.val;
                }
                root = root.right;
            } else if (target < root.val) {
                double diff = Math.abs(root.val - target);
                if (diff < min) {
                    min = Math.min(diff, min);
                    result = root.val;
                }
                root = root.left;
            } else {
                return root.val;
            }
        }
        return result;
    }
}
