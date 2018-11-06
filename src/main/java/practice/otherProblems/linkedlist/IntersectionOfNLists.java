package practice.otherProblems.linkedlist;

import java.util.*;

/**
 * Given n (of size m) Linked lists
 * <p/>
 * Print all set(head of linked list) of link list that intersect with each other.
 * <p/>
 * e.g.
 * <p/>
 * 1-->2-->3-->4-->5
 * 6-->7-->8-->4-->5
 * 8->9->10->11->12
 * 13->14->15->12
 * 16->17->18
 * <p/>
 * 1 6
 * 8 13
 * 16
 *
 * @author Yashraj R. Sontakke
 */
public class IntersectionOfNLists {

    public void getIntersection(Queue<Integer>[] queues){
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (Queue queue: queues){
            Integer head = (Integer)queue.peek();
            while (!queue.isEmpty()){
                Integer element = (Integer)queue.remove();
                if (map.containsKey(element)){
                    map.get(element).add(head);
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(head);
                    map.put(element, list);
                }
            }
        }
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        for (ArrayList<Integer> list : map.values()){
            if (list.size() > 1){
                result.add(list);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        IntersectionOfNLists i = new IntersectionOfNLists();
        Queue q1 = new LinkedList();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        Queue q2 = new LinkedList();
        q2.add(6);
        q2.add(7);
        q2.add(8);
        q2.add(4);
        q2.add(5);

        Queue q3 = new LinkedList();
        q3.add(8);
        q3.add(9);
        q3.add(10);
        q3.add(11);
        q3.add(12);

        Queue q4 = new LinkedList();
        q4.add(13);
        q4.add(14);
        q4.add(15);
        q4.add(12);

        Queue q5 = new LinkedList();
        q5.add(16);
        q5.add(17);
        q5.add(18);

        Queue<Integer>[] queues = new Queue[5];
        queues[0] =q1;
        queues[1] =q2;
        queues[2] =q3;
        queues[3] =q4;
        queues[4] =q5;

        i.getIntersection(queues);
    }
}
