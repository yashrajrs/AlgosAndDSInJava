package practice.problems.listsAndQueues;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Find the intersection between two lists.
 *
 * @author Yashraj R. Sontakke
 */
public class ListIntersection {

    /**
     * First approach using stacks.
     */
    public void getIntersection(Queue a, Queue b) {
        if (a.peek() == null || b.peek() == null) {
            System.out.println("No intersection");
            return;
        }
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        Integer intersection = null;

        while (a.peek() != null) {
            stack1.push((Integer) a.remove());
        }
        while (b.peek() != null) {
            stack2.push((Integer) b.remove());
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                intersection = stack1.peek();
                stack1.pop();
                stack2.pop();
            } else {
                break;

            }
        }
        if (intersection != null) {
            System.out.println(String.format("Intersection is at %s", intersection.toString()));
        } else {
            System.out.println("No intersection");
        }
    }

    /**
     * Second approach using single hash map.
     */
    public void findIntersection(Queue a, Queue b) {
        if (a.peek() == null || b.peek() == null) {
            System.out.println("No intersection");
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (a.peek() != null) {
            map.put((Integer) a.peek(), (Integer) a.peek());
            a.remove();
        }

        while (b.peek() != null) {
            if (map.get(b.peek()) != null) {
                System.out.println(String.format("Intersection is at %s", b.peek().toString()));
                return;
            }
            b.remove();
        }
        System.out.println("No intersection");
    }

    public static void main(String[] args) {
        ListIntersection listIntersection = new ListIntersection();
        Queue<Integer> a = new LinkedList<Integer>();
        Queue<Integer> b = new LinkedList<Integer>();
        Integer a1 = 1;
        Integer a2 = 2;
        Integer a3 = 3;

        Integer b1 = 4;
        Integer b2 = 5;
        Integer b3 = 6;

        Integer c1 = 7;
        Integer c2 = 8;
        Integer c3 = 9;

        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(c1);
        a.add(c2);
        a.add(c3);

        b.add(b1);
        b.add(b2);
        b.add(b3);
        b.add(c1);
        b.add(c2);
        b.add(c3);

        listIntersection.getIntersection(a, b);

        a = new LinkedList<Integer>();
        b = new LinkedList<Integer>();

        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(c1);
        a.add(c2);
        a.add(c3);

        b.add(b1);
        b.add(b2);
        b.add(b3);
        b.add(c1);
        b.add(c2);
        b.add(c3);

        listIntersection.findIntersection(a, b);

    }

}
