package practice.otherProblems;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * @author Yashraj R. Sontakke
 */
public class SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(10);
        TreeNode node12 = new TreeNode(20);
        TreeNode node13 = new TreeNode(30);
        TreeNode node14 = new TreeNode(40);
        TreeNode node15 = new TreeNode(50);


        TreeNode node21 = new TreeNode(10);
        TreeNode node22 = new TreeNode(20);
        TreeNode node23 = new TreeNode(30);
        TreeNode node24 = new TreeNode(40);
        TreeNode node25 = new TreeNode(50);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;

        node21.left = node22;
        node21.right = node23;
        node22.left = node24;
        node22.right = node25;


        SameTree sameTree = new SameTree();

        System.out.println(sameTree.isSameTree(node11, node21));

        node25.left = new TreeNode(122);
        System.out.println(sameTree.isSameTree(node11, node21));

    }
}
