package practice.careercup;


import practice.dataStructures.trees.TreeNode;

/**
 * Find the height difference between two nodes in a binary tree.


             5
        /          \
        3		  12
     /    \      /  \
    1	   4    6	 13
                /  \
                8	  9
                        \
                        10
 For example: For a given tree above, what would be the height difference between node 4 and node 10?
 */
public class TreeHeightBetweenNodes {

    public int getHeight(TreeNode root, int node1, int node2) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root, node1);
        if (leftHeight == -1) {
            return  -1;
        }
        int rightHeight = getHeight(root, node2);
        if (rightHeight == -1) {
            return  -1;
        }
        int heightDiff = Math.abs(leftHeight - rightHeight);
        return heightDiff;
    }

    public int getHeight(TreeNode root, int node) {
        if (root == null) {
            return -1;
        }
        if (root.getData() == node) {
            return 0;
        } else if (root.getData() > node) {
            return 1 + getHeight(root.getLeftChild(), node);
        } else {
            return 1 + getHeight(root.getRightChild(), node);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(10);

        root.setLeftChild(node1);
        root.setRightChild(node2);

        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        node2.setLeftChild(node5);
        node2.setRightChild(node6);

        node5.setLeftChild(node7);
        node5.setRightChild(node8);

        node8.setRightChild(node9);

        TreeHeightBetweenNodes t = new TreeHeightBetweenNodes();
        System.out.println(t.getHeight(root, 4, 10));
    }
}
