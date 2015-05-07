package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeFromSortedArray {

    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0){
            return null;
        }
        return sortedArrayToBST(num, 0, num.length-1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, start, mid-1);
        node.right = sortedArrayToBST(num, mid+1, end);
        return node;
    }

    public static void main(String[] args){
        BinaryTreeFromSortedArray b = new BinaryTreeFromSortedArray();
        int[] num = {1,2,3,4,5,6,7,8};
        TreeNode node = b.sortedArrayToBST(num);
        preOrder(node);
    }

    public static void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
