package practice.otherProblems.linkedlist;

import practice.otherProblems.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * @author Yashraj R. Sontakke
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                if(a.val > b.val){
                    return 1;
                }else if(a.val == b.val){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

        for(ListNode node : lists){
            if(node != null){
                q.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while(q.size() > 0){
            ListNode temp = q.poll();
            p.next = temp;
            if(temp.next != null){
                q.add(temp.next);
            }
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        MergeKLists m = new MergeKLists();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n21 = new ListNode(2);
        ListNode n22 = new ListNode(4);
        ListNode n23 = new ListNode(6);
        ListNode n24 = new ListNode(8);

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(5);
        ListNode n33 = new ListNode(8);
        ListNode n34 = new ListNode(10);

        n31.next = n32;
        n32.next = n33;
        n33.next = n34;

        ListNode[] input = {n1,n21,n31};
        ListNode res = m.mergeKLists(input);

        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
