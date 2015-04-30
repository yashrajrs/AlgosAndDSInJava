package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeFromInorderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int k = 0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i] == rootVal){
                k =i;
                break;
            }
        }

        root.left = buildTree(inorder, inStart, k-1, postorder, postStart, postStart + k - (inStart+1));
        root.right = buildTree(inorder, k+1, inEnd, postorder, postStart + k - inStart, postEnd-1);
        return root;
    }


    public static void main(String[] args){
        BinaryTreeFromInorderAndPostOrder b = new BinaryTreeFromInorderAndPostOrder();
        int[] inorder = {1, 3, 4, 5, 10, 12, 15, 18};
        int[] postorder = {1, 4, 3, 5, 12, 18, 15, 10};


        TreeNode n = b.buildTree(inorder, postorder);
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
