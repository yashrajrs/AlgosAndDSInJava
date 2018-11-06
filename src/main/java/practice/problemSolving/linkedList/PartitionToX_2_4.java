package practice.problemSolving.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;
import practice.otherProblems.ListNode;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x.
 * <p/>
 * <p/>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p/>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * @author Yashraj R. Sontakke
 */
public class PartitionToX_2_4 {
    public void partition(LinkedList list, Long x) {
        LinkedList beforeList = null;
        LinkedList afterList = null;

        Node n = list.getFirst();
        while (n != null) {
            if ((Long) n.getData() < x) {
                if (beforeList == null) {
                    beforeList = new LinkedList((Long) n.getData());
                } else {
                    beforeList.appendToTail((Long) n.getData());
                }
            } else {
                if (afterList == null) {
                    afterList = new LinkedList((Long) n.getData());
                } else {
                    afterList.appendToTail((Long) n.getData());
                }
            }
            n = n.getNext();
        }
        if (beforeList == null) {
            afterList.printData();
            return;
        }
        n = afterList.getFirst();
        while (n != null) {
            beforeList.appendToTail((Long) n.getData());
            n = n.getNext();
        }
        beforeList.printData();
    }


    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode next = fakeHead2;

        while (p != null) {
            if (p.val < x) {
                p = p.next;
                prev = prev.next;
            } else {
                next.next = p;
                next = next.next;

                prev.next = p.next;
                p = prev.next;

            }
        }
        next.next = null;
        prev.next = fakeHead2.next;
        return fakeHead1.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;

        cur1.next = head;

        ListNode n = head;

        while(n != null) {
            if (n.val < x) {
                cur1 = cur1.next;
            } else {
                cur2.next = n;
                cur2 = cur2.next;

                cur1.next = n.next;
            }
            n = n.next;
        }
        cur1.next = dummy2.next;
        cur2.next = null;
        return dummy1.next;
    }

    public static void main(final String[] args) {
        PartitionToX_2_4 r = new PartitionToX_2_4();
        LinkedList list = new LinkedList(90L);
        list.appendToTail(80L);
        list.appendToTail(70L);
        list.appendToTail(60L);
        list.appendToTail(50L);
        list.appendToTail(40L);

        r.partition(list, 55L);

        // 1->4->3->2->5->2

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next =n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode res = r.partition1(n1,3);

        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
