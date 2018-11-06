package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * @author Yashraj R. Sontakke
 */
public class RotateListRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <1) {
            return head;
        }
        int count = 0;
        ListNode node = head;

        while (node != null) {
            node = node.next;
            count++;
        }
        if (k >= count) {
            k = k % count;
        }
        if (k == 0){
            return head;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode copyNode = head;

        while (k > 0) {
            fastNode = fastNode.next;
            k--;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        ListNode result = slowNode.next;
        slowNode.next = null;
        fastNode.next = copyNode;
        return result;
    }

    public static void main(String[] args){
        RotateListRight r = new RotateListRight();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = r.rotateRight(node1, 2);

        while(result != null){
            System.out.print(result.val +" ");
            result = result.next;
        }
        System.out.println();

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        node11.next = node12;

        ListNode result1 = r.rotateRight(node11, 2);

        while(result1 != null){
            System.out.print(result1.val +" ");
            result1 = result1.next;
        }
    }
}
