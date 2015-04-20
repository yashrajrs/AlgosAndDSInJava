package practice.otherProblems;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
 *  5
 * | \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \     \
 * 7   2     1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @author Yashraj R. Sontakke
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        ArrayList<Integer> sums = new ArrayList<Integer>();

        list.add(root);
        sums.add(root.val);


        while(!list.isEmpty()){
            TreeNode node = list.remove(0);
            Integer currentSum = sums.remove(0);

            if(node.left == null && node.right == null && currentSum == sum){
                return true;
            }
            if(node.left != null){
                list.add(node.left);
                sums.add(currentSum + node.left.val);
            }
            if(node.right != null){
                list.add(node.right);
                sums.add(currentSum + node.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args){
        PathSum p = new PathSum();

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;
        node6.right = node9;

        System.out.println(p.hasPathSum(node1,22));
        System.out.println(p.hasPathSum(node1,23));

    }
}
