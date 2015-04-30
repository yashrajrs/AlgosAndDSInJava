package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.

 * For example,
 * Given

 *      1
 *    / \
 *   2   5
 * / \   \
 * 3   4   6
 *
 *The flattened tree should look like:

 * 1
 * \
 *  2
 *  \
 *   3
 *   \
 *    4
 *    \
 *     5
 *     \
 *      6
 *
 * @author Yashraj R. Sontakke
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(p!=null || !stack.isEmpty()){
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                p.right = temp;
            }
            p = p.right;
        }
    }

    public static void main(String[] args){
        FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;

        f.flatten(n1);

        TreeNode n = n1;

        while (n != null){
            System.out.print( n.val + " ");
            n = n.right;
        }
    }
}
