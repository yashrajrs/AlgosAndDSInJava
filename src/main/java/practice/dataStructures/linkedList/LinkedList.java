package practice.dataStructures.linkedList;

import practice.dataStructures.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implements a linked list.
 *
 * @author Yashraj R. Sontakke
 */
public class LinkedList {

    private Node first;

    public LinkedList(Long data) {
        first = new Node(data);
    }

    public Node getFirst() {
        return first;
    }

    public void appendToTail(final Long data) {
        Node newNode = new Node(data);
        Node n = first;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;

    }

    public Long deleteNode(Long data) {
        Node n = first;
        if (n.data == data) {
            first = first.next;
            return data;
        }
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return data;
            }
            n = n.getNext();
        }
        return null;

    }

    public void sortNodes() {
        Node node = first;
        ArrayList<Long> nodeData = new ArrayList<Long>();
        while (node != null) {
            nodeData.add((Long) node.data);
            node = node.next;
        }
        Collections.sort(nodeData);
        first = new Node(nodeData.get(0));
        for (int i = 1; i < nodeData.size(); i++) {
            appendToTail(nodeData.get(i));
        }
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

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10L);
        linkedList.appendToTail(20L);
        linkedList.appendToTail(30L);
        linkedList.appendToTail(30L);
        linkedList.appendToTail(40L);
        linkedList.appendToTail(20L);

        linkedList.printData();

        linkedList.deleteNode(30L);
        linkedList.printData();

        linkedList.sortNodes();
        linkedList.printData();
    }
}
