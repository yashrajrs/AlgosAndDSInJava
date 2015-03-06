package practice.problems.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveDuplicates_2_1 {
    /**
     * First approach O(n).
     */
    public void removeDuplicates(LinkedList list) {
        List<Long> nodeData = new ArrayList<Long>();
        Node node = list.getFirst();
        while (node != null) {
            if (nodeData.contains(node.getData())) {
                list.deleteNode((Long) node.getData());
            } else {
                nodeData.add((Long) node.getData());
            }
            node = node.getNext();
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

    public static void main(final String[] args) {
        RemoveDuplicates_2_1 r = new RemoveDuplicates_2_1();
        LinkedList list = new LinkedList(10L);

        list.appendToTail(20L);
        list.appendToTail(30L);
        list.appendToTail(30L);
        list.appendToTail(40L);
        list.appendToTail(20L);

        list.printData();

        r.deleteDuplicates(list);
        list.printData();
    }
}