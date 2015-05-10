package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p/>
 * return 1->4->3->2->5->NULL.
 * <p/>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 * @author Yashraj R. Sontakke
 */
public class ReverseLinkedListBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        p.next = reverse(p.next, n - m + 1);
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int n) {
        ListNode node = head, prev = null, next = null;
        for (int i = 0; i < n; i++) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = node;
        return prev;
    }


    public static void main(String[] args){
        ReverseLinkedListBetween r = new ReverseLinkedListBetween();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next =n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode result = r.reverseBetween(n1, 2, 4);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
