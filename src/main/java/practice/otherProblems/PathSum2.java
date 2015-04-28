package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
 *      5
 *     / \
 *    4   8
 *   /   / \
 *  11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author Yashraj R. Sontakke
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathSum(root, sum, result, new ArrayList<Integer>());
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> result, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        sum-= root.val;
        if(root.left == null && root.right == null && sum == 0){
            result.add(new ArrayList<Integer>(list));
        }else{
            pathSum(root.left, sum, result, list);
            pathSum(root.right, sum, result, list);
        }
        list.remove(list.size() -1);
    }

    public static void main(String[] args){
        PathSum2 p = new PathSum2();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        n4.left = n7;
        n4.right = n8;

        n6.left = n9;
        n7.right = n10;

        System.out.println(p.pathSum(n1, 22));

    }
}
