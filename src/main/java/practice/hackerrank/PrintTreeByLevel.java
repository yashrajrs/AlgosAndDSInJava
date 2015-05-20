package practice.hackerrank;

import practice.otherProblems.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/16/15
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class PrintTreeByLevel {

    public void printTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.remove();
                System.out.print(node.val + " ");
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public void printTreeRightSided(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.remove();
                if (i == 0){
                    System.out.println(node.val);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
            }
        }
    }



    public static void main(String[] args){
        PrintTreeByLevel p = new PrintTreeByLevel();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        p.printTree(n1);
        System.out.println();
        n3.right = null;

        p.printTreeRightSided(n1);

        System.out.println();
        n3.right = null;

        p.printTreeRightSided(n1);

        System.out.println();
        n3.left = null;

        p.printTreeRightSided(n1);
    }
}
