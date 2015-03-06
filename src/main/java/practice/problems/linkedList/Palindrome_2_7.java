package practice.problems.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a function to check if a linked list is a palindrome
 *
 * @author Yashraj R. Sontakke
 */
public class Palindrome_2_7 {

    public void isPalindrome(Node a) {
        List<Long> nodeData = new ArrayList<Long>();
        Node n = a;
        while (n != null) {
            nodeData.add((Long) n.data);
            n = n.next;
        }

        for (int i = 0; i < nodeData.size() / 2; i++) {
            if (nodeData.get(i) != nodeData.get(nodeData.size() - 1 - i)) {
                System.out.println("NOT PALINDROME");
                return;
            }
        }
        System.out.println("PALINDROME");
    }


    public static void main(final String[] args) {
        Palindrome_2_7 r = new Palindrome_2_7();
        LinkedList list = new LinkedList(1L);
        list.appendToTail(2L);
        list.appendToTail(3L);
        list.appendToTail(2L);
        list.appendToTail(1L);

        r.isPalindrome(list.getFirst());

    }
}
