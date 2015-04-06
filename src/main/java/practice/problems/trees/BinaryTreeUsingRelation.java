package practice.problems.trees;

import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a list of child->parent relationships, build a binary tree out of it.
 * All the element Ids inside the tree are unique.
 * <p/>
 * Example:
 * <p/>
 * Given the following relationships:
 * <p/>
 * Child Parent IsLeft
 * 15 20 true
 * 19 80 true
 * 17 20 false
 * 16 80 false
 * 80 50 false
 * 50 null false
 * 20 50 true
 * <p/>
 * <p/>
 * You should return the following tree:
 * 50
 * <p/>
 * 20 80
 * <p/>
 * 15 17 19 16
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeUsingRelation {

    public TreeNode buildTree(ArrayList<Relation> relations) {
        TreeNode node = null;

        for (Relation relation : relations) {
            if (relation.getParent() == null) {
                node = new TreeNode(relation.getChild());
                break;
            }
        }
        if (node == null) {
            return null;
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove(0);
            for (Relation relation : relations) {
                if (relation.getParent() == parent.getData()) {
                    TreeNode child = new TreeNode(relation.getChild());
                    child.setParent(parent);
                    if (relation.isLeft()) {
                        parent.setLeftChild(child);
                    } else {
                        parent.setRightChild(child);
                    }
                    queue.add(child);
                }
            }
        }

        return node;
    }


    public void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeftChild());
        System.out.print(node.getData() + " ");
        printInOrder(node.getRightChild());
    }

    public static void main(String[] args) {
        BinaryTreeUsingRelation b = new BinaryTreeUsingRelation();
        Relation relation1 = new Relation(15,20,true);
        Relation relation2 = new Relation(19,80,true);
        Relation relation3 = new Relation(17,20,false);
        Relation relation4 = new Relation(16,80,false);
        Relation relation5 = new Relation(80,50,false);
        Relation relation6 = new Relation(50,null,false);
        Relation relation7 = new Relation(20,50,true);

        TreeNode node = b.buildTree(new ArrayList<Relation>(Arrays.asList(relation1,relation2,relation3,relation4,relation5,relation6,relation7)));
        b.printInOrder(node);
    }
}
