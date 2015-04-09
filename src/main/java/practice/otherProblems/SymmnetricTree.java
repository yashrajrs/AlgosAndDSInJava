package practice.otherProblems;

import java.util.ArrayList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 * 1
 * / \
 * 2   2
 * /\  / \
 * 3 4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * @author Yashraj R. Sontakke
 */
public class SymmnetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        if (!isSymmetric(node1.left, node2.right)) {
            return false;
        }
        return isSymmetric(node1.right, node2.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        ArrayList<TreeNode> queue1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> queue2 = new ArrayList<TreeNode>();

        queue1.add(root);
        queue2.add(root);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.remove(0);
            TreeNode node2 = queue2.remove(0);

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue1.add(node1.left);
            queue1.add(node1.right);

            queue2.add(node2.right);
            queue2.add(node2.left);

        }
        return true;
    }


    public static void main(String[] args) {
        SymmnetricTree b = new SymmnetricTree();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(b.isSymmetric1(node1));
        System.out.println(b.isSymmetric(node1));

        node2.left = null;
        node2.right = node4;
        node3.left = null;
        System.out.println(b.isSymmetric1(node1));
        System.out.println(b.isSymmetric(node1));
    }
}
