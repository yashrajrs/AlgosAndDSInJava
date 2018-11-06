package practice.otherProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree

 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.

 * Initially, all next pointers are set to NULL.

 * Note:

 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 * and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *     1
 *   /  \
 *  2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *     1 -> NULL
 *   /  \
 *  2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 *
 * @author Yashraj R. Sontakke
 */
public class PopulateRightPointersOfEachNode {

    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeLinkNode node = queue.remove();
            if (node.left != null) {
                node.left.next = node.right;
                queue.add(node.left);
            }
            if (node.right != null) {
                if(node.next != null) {
                    node.right.next = node.next.left;
                }
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args){
        PopulateRightPointersOfEachNode p = new PopulateRightPointersOfEachNode();
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);

        n1.left= n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        p.connect(n1);

        System.out.println(n1.next);
        System.out.println(n2.next.val);
        System.out.println(n3.next);
        System.out.println(n4.next.val);
        System.out.println(n5.next.val);
        System.out.println(n6.next.val);
        System.out.println(n7.next);

    }
}
