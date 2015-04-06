package practice.otherProblems;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * For example,
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastRunner = head;
        ListNode nthNode = head;
        for (int i = 0; i < n; i++) {
            fastRunner = fastRunner.next;
        }
        if (fastRunner == null) {
            return nthNode.next;
        }
        while (fastRunner.next != null) {
            fastRunner = fastRunner.next;
            nthNode = nthNode.next;
        }
        nthNode.next = nthNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNode r = new RemoveNthNode();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n = r.removeNthFromEnd(n1, 2);
        printNode(n);

    }

    private static void printNode(ListNode output) {
        while (output != null) {
            System.out.print(output.val + " ");
            output = output.next;
        }
        System.out.println();
    }


}
