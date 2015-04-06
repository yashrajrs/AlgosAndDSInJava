package practice.otherProblems;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author Yashraj R. Sontakke
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0);
        ListNode current = output;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }
        return output.next;

    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode n = m.mergeTwoLists(node1,node4) ;
        printNode(n);
    }

    private static void printNode(ListNode output) {
        while(output != null){
            System.out.print( output.val + " ");
            output = output.next;
        }
        System.out.println();
    }
}
