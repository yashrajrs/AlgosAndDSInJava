package practice.problems.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x.
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

    public static void main(final String[] args) {
        PartitionToX_2_4 r = new PartitionToX_2_4();
        LinkedList list = new LinkedList(90L);
        list.appendToTail(80L);
        list.appendToTail(70L);
        list.appendToTail(60L);
        list.appendToTail(50L);
        list.appendToTail(40L);

        r.partition(list, 55L);
    }
}
