package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}
 *
 * @author Yashraj R. Sontakke
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        merge(head1, head2);
    }

    public ListNode reverse(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }

    public void merge(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
    }

    public static void main(String[] args) {
        ReorderList l = new ReorderList();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        l.reorderList(a);

        ListNode node = a;
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
