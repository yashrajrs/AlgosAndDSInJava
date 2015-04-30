package practice.otherProblems.sort;

import practice.otherProblems.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 * @author Yashraj R. Sontakke
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while(cur != null){
            ListNode pos = dummy;
            while(pos.next != null && pos.next.val < cur.val){
                pos = pos.next;
            }
            ListNode temp = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = temp;
        }
        return dummy.next;
    }


    public static void main(String[] args){
        InsertionSortList i = new InsertionSortList();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(10);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        printList(n1);
        ListNode node = i.insertionSortList(n1);
        printList(node);
    }

    public static void  printList(ListNode n){
        ListNode node = n;
        while(node != null){
            System.out.print( node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
