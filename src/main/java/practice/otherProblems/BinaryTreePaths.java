package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

 1
 /   \
 2     3
 \
 5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        String sb = "";
        ArrayList<String> result = new ArrayList<>();

        helper(root, sb, result);
        return result;
    }

    public void helper(TreeNode root, String sb, ArrayList<String> result) {
        if (root == null) {
            return;
        }
        sb = sb + "->" + root.val;
        if (root.left == null && root.right == null) {
            result.add(sb.substring(2));
            return;
        }
        if (root.left != null) {
            helper(root.left, sb, result);
        }
        if (root.right != null) {
            helper(root.right, sb, result);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths b = new BinaryTreePaths();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;
        System.out.println(b.binaryTreePaths(node1));
    }
}
