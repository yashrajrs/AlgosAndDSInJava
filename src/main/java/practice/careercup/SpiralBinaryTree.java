package practice.careercup;

import practice.dataStructures.linkedList.LinkedList;
import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree print it in inward spiral order i.e first print level 1, then level n, then level 2, then n-1 and so on.

 For Ex -
        1
      /    \
     2	    3
   /  \    / \
   4  5   6   7
 / \ / \  / \ / \
 8 9 10 11 12 13 14 15

 Print- 1 15 14 13 12 11 10 9 8 2 3 7 6 5 4

 Follow up question - Extend the algorithm to n-ary tree.
 */
public class SpiralBinaryTree {

    public List<Integer> spiralTree(TreeNode root) {
        Map<Integer, ArrayList<TreeNode>> result = new HashMap<Integer, ArrayList<TreeNode>>();
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            for (int i=0;i<size;i++) {
                TreeNode n = queue.remove(0);
                if (n.getLeftChild() != null) {
                    queue.add(n.getLeftChild());
                }
                if (n.getRightChild() != null) {
                    queue.add(n.getRightChild());
                }
                if (level%2==0) {
                    list.add(0, n);
                } else {
                    list.add(n);
                }
            }
            result.put(level, list);
            level++;
        }
        List<Integer> output = new ArrayList<Integer>();
        int left = 0, right = result.size() -1;
        while (left <right) {
            for (TreeNode node : result.get(left)) {
                output.add(node.getData());
            }
            left++;
            for (TreeNode node : result.get(right)) {
                output.add(node.getData());
            }
            right--;
        }
        return output;
    }


    public static void main(String[] args) {
        SpiralBinaryTree s = new SpiralBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);

        node1.setLeftChild(node2);
        node1.setRightChild(node3);

        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);

        node4.setLeftChild(node8);
        node4.setRightChild(node9);
        node5.setLeftChild(node10);
        node5.setRightChild(node11);

        node6.setLeftChild(node12);
        node6.setRightChild(node13);
        node7.setLeftChild(node14);
        node7.setRightChild(node15);

        List<Integer> output = s.spiralTree(node1);
        System.out.println(output.toString());
    }
}
