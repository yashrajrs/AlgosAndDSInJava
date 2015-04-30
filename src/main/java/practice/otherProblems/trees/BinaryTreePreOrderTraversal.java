package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *   \
 *   2
 *  /
 * 3
 * return [1,2,3].

 * Note: Recursive solution is trivial, could you do it iteratively?

 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            result.add(t.val);

            if(t.right != null){
                stack.push(t.right);
            }

            if(t.left != null){
                stack.push(t.left);
            }
        }
        return result;
    }

    public static void main(String[] args){
        BinaryTreePreOrderTraversal b = new BinaryTreePreOrderTraversal();
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        n11.right = n12;
        n12.left = n13;

        System.out.println(b.preorderTraversal(n11).toString());


        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(b.preorderTraversal(n1).toString());

    }
}
