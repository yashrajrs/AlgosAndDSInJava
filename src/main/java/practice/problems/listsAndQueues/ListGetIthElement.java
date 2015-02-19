package practice.problems.listsAndQueues;

import practice.dataStructures.Node;
import practice.dataStructures.queue.Queue;

/**
 * Retrieves the ith element from the tail of the list.
 *
 * @author Yashraj R. Sontakke
 */
public class ListGetIthElement {

    public Object getIthInteger(Queue queue, int i){
        Node fastNode = queue.first;
        for (int k =0;k<i;k++){
            fastNode = fastNode.getNext();
        }
        Node iNode = queue.first;
        while (fastNode!=null){
            fastNode = fastNode.getNext();
            iNode = iNode.getNext();
        }
        return iNode.getData();
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        ListGetIthElement l = new ListGetIthElement();
        System.out.println(l.getIthInteger(queue, 2));
        System.out.println(l.getIthInteger(queue,3));

    }
}
