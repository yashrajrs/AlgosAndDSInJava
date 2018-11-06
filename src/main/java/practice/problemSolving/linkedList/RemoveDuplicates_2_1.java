package practice.problemSolving.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;
import practice.otherProblems.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * <p/>
 * <p/>
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p/>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveDuplicates_2_1 {
    /**
     * First approach O(n).
     */
    public void removeDuplicates1(LinkedList list) {
        List<Long> nodeData = new ArrayList<Long>();
        Node first = list.getFirst();
        nodeData.add((Long) first.getData());
        while (first != null) {
            Node second = first.getNext();
            if (second != null && nodeData.contains(second.getData())) {
                first.setNext(second.getNext());
            } else if (second != null) {
                nodeData.add((Long) second.getData());
            }
            first = first.getNext();
        }
    }

    /**
     * Second approach O(n2).
     */
    public void deleteDuplicates(LinkedList list) {
        if (list.getFirst() == null) {
            return;
        }
        Node current = list.getFirst();
        while (current != null) {
            Node runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();

        }

    }

    /**
     * Third approach O(n). List is sorted
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        ListNode p = head;
        int cur = p.val;
        int count =0;
        p = p.next;
        while (p != null){
            if (p.val == cur){
                count++;
                p = p.next;
            }else{
                if (count == 0){
                    curNode.next = new ListNode(cur);
                    curNode = curNode.next;
                }
                cur = p.val;
                count = 0;
                p = p.next;
            }
        }
        if (count == 0){
            curNode.next = new ListNode(cur);
        }
        return dummy.next;

    }

    public static void main(final String[] args) {
        RemoveDuplicates_2_1 r = new RemoveDuplicates_2_1();
//        LinkedList list = new LinkedList(10L);
//
//        list.appendToTail(20L);
//        list.appendToTail(30L);
//        list.appendToTail(30L);
//        list.appendToTail(40L);
////        list.appendToTail(20L);
//
//        list.printData();
//
//        r.removeDuplicates1(list);
//        list.printData();


        // 1->2->3->3->4->4->5

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode res = r.deleteDuplicates(n1);
        printList(res);

        // 1->1->1->2->3

        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(1);
        ListNode n13 = new ListNode(1);
        ListNode n14 = new ListNode(2);
        ListNode n15 = new ListNode(3);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;

        ListNode res1 = r.deleteDuplicates(n11);
        printList(res1);
    }

    private static void  printList(ListNode node){
        while ( node!=null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}