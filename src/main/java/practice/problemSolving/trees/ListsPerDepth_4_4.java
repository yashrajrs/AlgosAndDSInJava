package practice.problemSolving.trees;

import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists
 *
 * @author Yashraj R. Sontakke
 */
public class ListsPerDepth_4_4 {

    public ArrayList<ArrayList<TreeNode>> getLists(TreeNode root){
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        if (root==null){
            return result;
        }

        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        while (current.size()>0){
            result.add(current);
            ArrayList<TreeNode> parents = current;
            current = new ArrayList<TreeNode>();
            for (TreeNode parent:parents){
                if (parent.getLeftChild()!=null){
                    current.add(parent.getLeftChild());
                }
                if (parent.getRightChild()!=null){
                    current.add(parent.getRightChild());
                }
            }
        }
        return result;
    }


    public ArrayList<ArrayList<TreeNode>> getLists1(TreeNode root){
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        if (root==null){
            return result;
        }

        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        while (current.size()>0){
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            int size = current.size();
            for(int i=0;i<size;i++){
                TreeNode node = current.remove(0);
                if (node.getLeftChild() != null){
                    current.add(node.getLeftChild());
                }
                if (node.getRightChild() != null){
                    current.add(node.getRightChild());
                }
                list.add(node);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.addData(80);
        b.addData(73);
        b.addData(78);
        b.addData(60);
        b.addData(85);
        b.addData(90);

        ListsPerDepth_4_4 listsPerDepth = new ListsPerDepth_4_4();
        ArrayList<ArrayList<TreeNode>> lists = listsPerDepth.getLists(b.parent);
        System.out.println(lists.toString());

        ArrayList<ArrayList<TreeNode>> lists1 = listsPerDepth.getLists1(b.parent);
        System.out.println(lists1.toString());

    }
}
