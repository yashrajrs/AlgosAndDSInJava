package practice.otherProblems;

import practice.dataStructures.linkedList.Node;

import java.util.LinkedList;
import java.util.Stack;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author Yashraj R. Sontakke
 */
public class AddTwoList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode output = null;
        ListNode first = l1, second = l2, third = output;
        while (first!=null || second !=null){
            if (first!=null){
                carry = carry + first.val;
                first = first.next;
            }
            if(second!=null){
                carry = carry + second.val;
                second = second.next;
            }
            if (output == null){
                output = new ListNode(carry%10);
                third = output;
            }else{
                third.next = new ListNode(carry%10);
                third = third.next;
            }
            carry /= 10;
        }
        if (carry > 0){
            third.next = new ListNode(carry);
        }
        return output;
    }

    public static void main(String[] args){
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Output: 7 -> 0 -> 8
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        AddTwoList a =new AddTwoList();
        ListNode output;
        output= a.addTwoNumbers(node1,node4);


        printNode(output);

        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(5);

        output = a.addTwoNumbers(node11,node12);

        printNode(output);

        ListNode node21 = new ListNode(0);
        ListNode node22 = new ListNode(1);

        output = a.addTwoNumbers(node21,node22);

        printNode(output);

        ListNode node31 = new ListNode(1);
        ListNode node32 = new ListNode(8);
        node31.next = node32;

        output = a.addTwoNumbers(node31,node21);

        printNode(output);

        ListNode node41 = new ListNode(9);
        ListNode node42 = new ListNode(8);
        ListNode node43 = new ListNode(1);
        node41.next = node42;

        output = a.addTwoNumbers(node41,node43);

        printNode(output);



    }

    private static void printNode(ListNode output) {
        while(output != null){
            System.out.print( output.val + " ");
            output = output.next;
        }
        System.out.println();
    }

}
