package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 * An example is the root-to-leaf path 1->2->3 which represents the number 123.

 * Find the total sum of all root-to-leaf numbers.

 * For example,

 * 1
 * | \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.

 * Return the sum = 12 + 13 = 25.
 *
 * @author Yashraj R. Sontakke
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumNumbers(root,0);
    }

    public int sumNumbers(TreeNode node, int sum){
        if (node == null){
            return 0;
        }
        int res = sum *10 + node.val;
        if(node.left == null && node.right == null){
            return res;
        }
        return sumNumbers(node.left, res) + sumNumbers(node.right, res);
    }

    public static void main(String[] args){
        SumRootToLeafNumbers s = new SumRootToLeafNumbers();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(s.sumNumbers(node1));
    }
}
