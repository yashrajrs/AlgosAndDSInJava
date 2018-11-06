package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 7/4/15
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeCountNodesValueLessThanParent {

    public int getNodeCount(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftNodeCount = getNodeCount(node.left);
        int rightNodeCount = getNodeCount(node.right);

        int count = 0;
        if (node.left !=null && node.val > node.left.val){
            count++;
        }
        if (node.right !=null && node.val > node.right.val){
            count++;
        }
        return leftNodeCount + rightNodeCount + count;
    }

    public static void main(String[] args){
        BinaryTreeCountNodesValueLessThanParent b = new BinaryTreeCountNodesValueLessThanParent();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(12);

        //        10
        //      /   \
        //     8     6
        //    / \   / \
        //   4   2 3   12

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(b.getNodeCount(node1));



    }
}
