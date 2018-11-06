package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 *
 * @author Yashraj R. Sontakke
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println(slow.val);
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycle2 l = new LinkedListCycle2();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;

        System.out.println(l.detectCycle(a).val);
    }
}
