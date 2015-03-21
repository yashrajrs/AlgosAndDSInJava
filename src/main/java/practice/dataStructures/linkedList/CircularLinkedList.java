package practice.dataStructures.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a circular linked list.
 *
 * @author Yashraj R. Sontakke
 */
public class CircularLinkedList {
    Node start, end;

    public CircularLinkedList(Long data) {
        start = new Node(data);
        end = start;
    }

    public void addToStart(Long data) {
        Node newNode = new Node(data);
        newNode.setNext(start);
        end.setNext(newNode);
        start = newNode;
    }

    public void addToEnd(Long data) {
        Node newNode = new Node(data);
        newNode.setNext(start);
        end.setNext(newNode);
        end = newNode;
    }

    public Long deleteFirst() {
        if (start != null) {
            Long data = (Long) start.getData();
            start = start.getNext();
            end.setNext(start);
            return data;
        }
        return null;
    }

    public Long deleteEnd() {
        if (end != null) {
            if (end == start) {
                Long data = (Long) start.getData();
                start = null;
                end = null;
                return data;
            }
            Node n = start;
            while (n.getNext() != end) {
                n = n.getNext();
            }
            n.setNext(start);
            end = n;
        }
        return null;
    }

    public void printData() {
        Node n = start;
        List toBePrinted = new ArrayList<Long>();
        while (n != null) {
            toBePrinted.add(n.getData());
            n = n.getNext();
            if (n == start) {
                break;
            }
        }
        System.out.println(toBePrinted.toString());
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList(10L);
        circularLinkedList.addToStart(7L);
        circularLinkedList.addToStart(5L);
        circularLinkedList.printData();

        circularLinkedList.addToEnd(12L);
        circularLinkedList.addToEnd(15L);
        circularLinkedList.printData();

        circularLinkedList.deleteFirst();
        circularLinkedList.deleteEnd();
        circularLinkedList.printData();
    }
}
