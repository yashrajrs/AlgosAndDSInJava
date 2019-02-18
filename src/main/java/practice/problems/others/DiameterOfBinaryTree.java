package practice.problems.others;

import practice.otherProblems.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
    1
   / \
  2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
    }

    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left+right+1);
        return Math.max(left,right) +1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right =n3;
        n2.left = n4;
        n2.right=n5;
        System.out.println(d.diameterOfBinaryTree(n1));
    }
}
