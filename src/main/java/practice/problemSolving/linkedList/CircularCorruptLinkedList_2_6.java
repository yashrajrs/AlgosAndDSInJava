package practice.problemSolving.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a circular linked list, implement an algorithm which returns the node at the
 * beginning of the loop.
 *
 * @author Yashraj R. Sontakke
 */
public class CircularCorruptLinkedList_2_6 {

    public void findCorruptNode(Node a) {
        List<Node> nodeData = new ArrayList<Node>();
        Node n = a;
        while (n != null) {
            if (nodeData.contains(n)) {
                System.out.println("CORRUPT NODE " + n.data);
                break;
            }
            nodeData.add(n);
            n = n.next;
        }
    }

    public static void main(final String[] args) {
        CircularCorruptLinkedList_2_6 r = new CircularCorruptLinkedList_2_6();
        LinkedList list = new LinkedList(1L);
        Node a = new Node(2L);
        Node b = new Node(4L);
        Node c = new Node(5L);
        Node d = new Node(3L);

        c.setNext(d);
        b.setNext(c);
        a.setNext(list.getFirst());
        list.getFirst().setNext(a);

        r.findCorruptNode(list.getFirst());

    }
}
