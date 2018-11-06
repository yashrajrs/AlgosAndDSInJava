package practice.problems.trees;

import practice.otherProblems.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement an iterator for a binary search tree that will
 * iterate the nodes by value in ascending order
 *
 * @author Yashraj R. Sontakke
 */
public class IteratorBinaryTree implements Iterator{


    private TreeNode root;
    private Queue<Integer> queue;

    public IteratorBinaryTree(TreeNode root){
        this.root = root;
        queue = new LinkedList<Integer>();
        inorderTraversal(root);
    }

    public void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        queue.add(node.val);
        inorderTraversal(node.right);
    }

//    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

//    @Override
    public Object next() {
        return queue.poll();
    }

//    @Override
    public void remove() {
    }


    public static void main(String[] args){

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

        IteratorBinaryTree i = new IteratorBinaryTree(n1);
        while (i.hasNext()){
            System.out.println(i.next());
        }

    }
}
