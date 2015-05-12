package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author Yashraj R. Sontakke
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        return merge(slow, fast);
    }

    private ListNode merge(ListNode slow, ListNode fast){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(slow != null && fast != null){
            if(slow.val < fast.val){
                cur.next = slow;
                slow = slow.next;
            }else{
                cur.next = fast;
                fast= fast.next;
            }
            cur = cur.next;
        }
        if(slow != null){
            cur.next = slow;
        }else if(fast != null){
            cur.next = fast;
        }
        return head.next;
    }


    public static void main(String[] args){
        SortList s = new SortList();
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode res = s.sortList(n1);

        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
