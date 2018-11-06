package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * sum property is as follows:
 * For every node, value stored in it must be equal to sum of values in left and right child. Consider value as 0 for NULL children.
 * e.g. parent = 10, left child = 8 and right child = 2 then sum property satisfied. parent = left + right. in this case return true
 * e.g. parent = 10, left child = 7 and right child = 2 then sum property failed. parent != left + right. in this case return false
 *
 * @author Yashraj R. Sontakke
 */
public class NAryTree {

    public int checkTree(TreeNode node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return node.val;
        }
        int leftSum = checkTree(node.left);
        if(leftSum == -1){
            return -1;
        }

        int rightSum = checkTree(node.right);
        if (rightSum == -1){
            return -1;
        }

        if (leftSum + rightSum != node.val){
            return -1;
        }
        return node.val;
    }

    public void isNAry(TreeNode root){
        if (checkTree(root) == -1){
            System.out.println("Not");
            return;
        }
        System.out.println("Is");
    }


    public static void main(String[] args){
        NAryTree n = new NAryTree();

        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        n.isNAry(n1);

        n3.right = new TreeNode(10);
        n.isNAry(n1);

    }
}
