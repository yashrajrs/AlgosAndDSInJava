package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

import java.util.List;

/**
 * Created by yashraj on 8/3/16.
 */
public class ReverseList {

    public ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }


        return prev;
    }

    public static void main(String[] args){
        ReverseList r = new ReverseList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next =n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode result = r.reverse(n1);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
