package practice.otherProblems;

/**
 * Given a binary tree, find its maximum depth.

 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author Yashraj R. Sontakke
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree b = new MaximumDepthOfBinaryTree();

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(40);
        TreeNode node5 = new TreeNode(50);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(b.maxDepth(node1));
        node1.right = null;
        System.out.println(b.maxDepth(node1));
        node4.left = new TreeNode(100);
        System.out.println(b.maxDepth(node1));
    }
}
