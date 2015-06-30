package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 *
 * @author Yashraj R. Sontakke
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        LinkedListCycle l = new LinkedListCycle();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next =b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;

        System.out.println(l.hasCycle(a));
    }
}
