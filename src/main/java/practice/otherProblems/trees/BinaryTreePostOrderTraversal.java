package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversalWithStacks(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null){
                stack1.push(node.left);
            }
            if (node.right != null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }
        return result;
    }

    public static void main(String[] args){
        BinaryTreePostOrderTraversal p = new BinaryTreePostOrderTraversal();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.right = n2;
        n2.left = n3;

        System.out.println(p.postorderTraversal(n1).toString());
        System.out.println(p.postorderTraversalWithStacks(n1).toString());
    }
}
