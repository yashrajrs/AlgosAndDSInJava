package practice.problemSolving.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * @author Yashraj R. Sontakke
 */
public class KthToLastElement_2_2 {

    public void findKthToLast(LinkedList list, int kthValue) {
        Node fastRunner = list.getFirst();
        for (int i = 0; i < kthValue; i++) {
            if (fastRunner == null) {
                System.out.println("k greater than linked list size");
                return;
            }
            fastRunner = fastRunner.getNext();
        }
        if (fastRunner == null) {
            System.out.println("k greater than linked list size");
            return;
        }
        Node kthElement = list.getFirst();
        while (fastRunner != null) {
            fastRunner = fastRunner.getNext();
            kthElement = kthElement.getNext();
        }
        System.out.println(kthElement.getData());
    }


    public static void main(final String[] args) {
        KthToLastElement_2_2 r = new KthToLastElement_2_2();
        LinkedList list = new LinkedList(10L);
        list.appendToTail(20L);
        list.appendToTail(30L);
        list.appendToTail(30L);
        list.appendToTail(40L);
        list.appendToTail(20L);

        list.printData();
        r.findKthToLast(list, 2);
    }
}
