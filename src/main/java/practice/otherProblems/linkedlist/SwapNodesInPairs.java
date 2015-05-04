package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 * @author Yashraj R. Sontakke
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;

        while(p.next != null && p.next.next != null){
            ListNode t1 = p;
            p = p.next;
            t1.next = p.next;

            ListNode t2 = p.next.next;
            p.next.next = p;
            p.next = t2;
        }
        return h.next;
    }

    public static void main(String[] args){
        SwapNodesInPairs s = new SwapNodesInPairs();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printList(n1);

        ListNode node = s.swapPairs(n1);
        printList(node);
    }

    public static void  printList(ListNode n){
        ListNode node = n;
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
