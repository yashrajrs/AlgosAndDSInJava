package practice.dataStructures.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a doubly linked list.
 *
 * @author Yashraj R. Sontakke
 */
public class DoublyLinkedList {

    private Node first, last;

    public DoublyLinkedList(Long data) {
        first = new Node(data);
        last = first;
    }

    public void addFirst(Long data) {
        final Node newNode = new Node(data);
        newNode.setNext(first);
        first.setPrev(newNode);
        first = newNode;
    }

    public void addLast(Long data) {
        final Node newNode = new Node(data);
        last.setNext(newNode);
        newNode.setPrev(last);
        last = newNode;
    }

    public Long removeFirst() {
        if (first != null) {
            Long data = (Long) first.getData();
            first = first.getNext();
            first.setPrev(null);
            return data;
        }
        return null;
    }

    public Long removeLast() {
        if (last != null) {
            Long data = (Long) last.getData();
            last = last.getPrev();
            last.setNext(null);
            return data;
        }
        return null;
    }

    public Long remove(Long data) {
        if (first.getData() == data) {
            first = first.getNext();
            first.setPrev(null);
            return data;
        }
        Node n = first;
        while (n.getNext() != null) {
            if (n.getNext().getData() == data) {
                Node node = n.getNext().getNext();
                n.setNext(node);
                if (node != null) {
                    node.setPrev(n);
                }
                return data;

            }
            n = n.getNext();
        }
        return null;
    }

    public void printData() {
        Node n = first;
        List toBePrinted = new ArrayList<Long>();
        while (n != null) {
            toBePrinted.add(n.getData());
            n = n.getNext();
        }
        System.out.println(toBePrinted.toString());
    }

    public void printDataReverse() {
        Node n = last;
        List toBePrinted = new ArrayList<Long>();
        while (n != null) {
            toBePrinted.add(n.getData());
            n = n.getPrev();
        }
        System.out.println(toBePrinted.toString());
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10L);
        doublyLinkedList.addFirst(7L);
        doublyLinkedList.addFirst(5L);
        doublyLinkedList.printData();

        doublyLinkedList.addLast(15L);
        doublyLinkedList.addLast(18L);
        doublyLinkedList.printData();

        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();

        doublyLinkedList.printData();

        doublyLinkedList.addFirst(3L);

        doublyLinkedList.remove(10L);

        doublyLinkedList.printData();
        doublyLinkedList.printDataReverse();

    }
}
