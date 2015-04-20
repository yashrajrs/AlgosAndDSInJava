package practice.otherProblems;

import java.util.ArrayList;

/**
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author Yashraj R. Sontakke
 */
public class MinimumDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        nodes.add(root);
        counts.add(1);

        while (!nodes.isEmpty()){
            TreeNode curr = nodes.remove(0);
            Integer count = counts.remove(0);

            if (curr.left == null && curr.right == null){
                return count;
            }
            if (curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
            if (curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        MinimumDepthBinaryTree m = new MinimumDepthBinaryTree();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;
        node4.right = node7;

        System.out.println(m.minDepth(node1));

        node3.left = node6;
        node3.right = node7;

        System.out.println(m.minDepth(node1));

    }
}
