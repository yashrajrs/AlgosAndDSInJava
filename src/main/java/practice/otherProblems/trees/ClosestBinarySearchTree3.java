package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Note:

 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 Example:

 Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

 4
 / \
 2   5
 / \
 1   3

 Output: [4,3]
 */
public class ClosestBinarySearchTree3 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        closestKValues(root, target, k, result);
        return result;
    }

    public void closestKValues(TreeNode root, double target, int k, LinkedList<Integer> result) {
        if (root == null) {
            return;
        }

        closestKValues(root.left, target, k, result);
        if (result.size() < k) {
            result.offerLast(root.val);
        } else if (Math.abs(target - root.val) < Math.abs(target - result.peek())) {
            result.pollFirst();
            result.offerLast(root.val);
        }

        closestKValues(root.right, target, k, result);
    }
}
