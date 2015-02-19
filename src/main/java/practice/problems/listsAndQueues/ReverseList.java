package practice.problems.listsAndQueues;

import practice.dataStructures.Node;
import practice.dataStructures.queue.Queue;

/**
 * Returns the reverse list.
 *
 * @author Yashraj R. Sontakke
 */
public class ReverseList {

    public Queue reverse(Queue input) {
        Queue output = new Queue();
        Node n = input.first;
        while (n != null) {
            if (output.first == null) {
                output.first = new Node(n.getData());
                output.last = output.first;
            } else {
                Node newNode = new Node(n.getData());
                newNode.setNext(output.first);
                output.first = newNode;
            }
            n = n.getNext();

        }

        return output;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        ReverseList r = new ReverseList();

        Queue output = r.reverse(queue);
        output.printQueue();
    }
}
