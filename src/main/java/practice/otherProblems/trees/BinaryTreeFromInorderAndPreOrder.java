package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given inorder and preorder traversal of a tree, construct the binary tree.

 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeFromInorderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length -1;
        return buildTree(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int k = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootVal){
                k = i;
                break;
            }
        }
        root.left = buildTree(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k-1);
        root.right = buildTree(preorder, preStart + k - inStart+ 1, preEnd, inorder, k+1, inEnd);
        return root;
    }

    public static void main(String[] args){
        BinaryTreeFromInorderAndPreOrder b = new BinaryTreeFromInorderAndPreOrder();
        int[] inorder = {1, 3, 4, 5, 10, 12, 15, 18};
        int[] preorder = {10, 5, 3, 1, 4, 15, 12, 18};


        TreeNode n = b.buildTree(preorder, inorder);
        b.printInOrder(n);
    }

    /**
     * Prints in order tree for the node provided
     */
    public void printInOrder(final TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.val);
            printInOrder(node.right);
        }
    }
}
