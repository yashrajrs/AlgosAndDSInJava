package practice.otherProblems.trees;

import practice.otherProblems.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




 Example 1:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.
 Example 2:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


 Note:

 All of the nodes' values will be unique.
 p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        CounterNode node = helper(root, p, q);
        return node.node;
    }

    public CounterNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new CounterNode(null, 0);
        }

        CounterNode left = helper(root.left, p, q);
        if (left.count == 2) {
            return left;
        }

        CounterNode right = helper(root.right, p, q);
        if (right.count == 2) {
            return right;
        }

        int c = left.count+right.count + (root==p?1:0) + (root==q?1:0);
        return new CounterNode(root, c);
    }

    class CounterNode {
        public TreeNode node;
        int count;

        public CounterNode(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor commonAncestor = new LowestCommonAncestor();

//                        3
//                      /   \
//                     5     1
//                   /  \   / \
//                  6   2  0  8
//                     / \
//                    7   4

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

//        System.out.println(commonAncestor.lowestCommonAncestor(node1, node2, node3));
        System.out.println(commonAncestor.lowestCommonAncestor(node1, node2, node9));
    }

}
