package practice.problems.listsAndQueues;

import practice.dataStructures.linkedList.DoublyLinkedList;
import practice.dataStructures.linkedList.Node;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/31/15
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class ReverseDoublyLinkedList {

    public DoublyLinkedList reverse(DoublyLinkedList input){

        Node n = input.getLast();
        DoublyLinkedList output = new DoublyLinkedList((Long)n.getData());
//        Node last = output.getLast();

        n = n.getPrev();

        while (n!= null){
            Node newNode = new Node(n.getData());

            output.getLast().setNext(newNode);
            newNode.setPrev(output.getLast());
            output.setLast( newNode);

            n = n.getPrev();

        }

        return output;

    }


    public void reverse1(DoublyLinkedList input){
        Node n = input.getLast();
        Node list = new Node(n.getData());
        Node current = list;
        n = n.getPrev();
        while (n!=null){
            Node newNode = new Node(n.getData());
            current.setNext(newNode);
            newNode.setPrev(current);
            current = current.getNext();
            n = n.getPrev();
        }

        Node node = list;
        while(node!=null){
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();

        node = current;
        while(node!=null){
            System.out.print(node.getData() + " ");
            node = node.getPrev();
        }
        System.out.println();
    }

    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1L);
        doublyLinkedList.addLast(2L);
        doublyLinkedList.addLast(3L);
        doublyLinkedList.addLast(4L);
        doublyLinkedList.addLast(5L);
        doublyLinkedList.printData();

        ReverseDoublyLinkedList r = new ReverseDoublyLinkedList();

        DoublyLinkedList output = r.reverse(doublyLinkedList);
        output.printData();
        output.printDataReverse();

        r.reverse1(doublyLinkedList);
    }
}
