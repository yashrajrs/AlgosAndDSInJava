package practice.otherProblems;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode node = head.next;

        while(node != null){
            if(node.val == prev.val){
                prev.next = node.next;
                node = node.next;
            }else{
                node = node.next;
                prev = prev.next;
            }

        }
        return head;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        ListNode n1 = r.deleteDuplicates(node1);
        printList(n1);

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(2);
        ListNode node14 = new ListNode(3);
        ListNode node15 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        ListNode n2 = r.deleteDuplicates(node11);
        printList(n2);

    }

    public static void printList(ListNode n){
        while(n!=null){
            System.out.print(n.val);
            n = n.next;
        }
        System.out.println();
    }
}
