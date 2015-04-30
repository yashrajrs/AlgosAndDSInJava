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
    public void removeDuplicates1(LinkedList list) {
       List<Long> nodeData = new ArrayList<Long>();
        Node first = list.getFirst();
        nodeData.add((Long)first.getData());
        while (first!=null){
            Node second = first.getNext();
            if (second != null && nodeData.contains(second.getData())){
                first.setNext(second.getNext());
            }else if(second != null){
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

    public static void main(final String[] args) {
        RemoveDuplicates_2_1 r = new RemoveDuplicates_2_1();
        LinkedList list = new LinkedList(10L);

        list.appendToTail(20L);
        list.appendToTail(30L);
        list.appendToTail(30L);
        list.appendToTail(40L);
//        list.appendToTail(20L);

        list.printData();

        r.removeDuplicates1(list);
        list.printData();
    }
}