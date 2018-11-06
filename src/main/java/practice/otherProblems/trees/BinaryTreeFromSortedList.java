package practice.otherProblems.trees;

import practice.otherProblems.ListNode;
import practice.otherProblems.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeFromSortedList {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode start, ListNode end){
        if(start == null || start == end){
            return null;
        }
        if(start.next == end){
            return new TreeNode(start.val);
        }

        ListNode node1 = start;
        ListNode node2 = start;

        while(node1 != end){
            node1 = node1.next;
            if(node1 == end){
                break;
            }
            node1 = node1.next;
            if(node1 == end){
                break;
            }
            node2 = node2.next;
        }
        TreeNode root = new TreeNode(node2.val);
        root.left = sortedListToBST(start, node2);
        root.right = sortedListToBST(node2.next, end);
        return root;
    }



    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        BinaryTreeFromSortedList b = new BinaryTreeFromSortedList();
        TreeNode result = b.sortedListToBST(node1);
        preOrder(result);
    }

    public static void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
