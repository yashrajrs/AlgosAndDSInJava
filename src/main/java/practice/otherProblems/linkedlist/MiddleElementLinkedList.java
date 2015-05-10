package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Write a function to print the middle of a given linked list
 *
 * @author Yashraj R. Sontakke
 */
public class MiddleElementLinkedList {

    public int getMiddleElement(ListNode head){
        if (head == null){
            return -1;
        }else if (head.next == null){
            return head.val;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode !=null && fastNode.next !=null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode.val;
    }

    public static void main(String[] args){
        MiddleElementLinkedList m = new MiddleElementLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(m.getMiddleElement(n1));

        n4.next = null;

        System.out.println(m.getMiddleElement(n1));

    }
}
