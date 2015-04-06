package practice.problems.linkedList;

import practice.dataStructures.Node;
import practice.dataStructures.linkedList.LinkedList;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the Ts digit is at the
 * head of the list. Write a function that adds the two numbers and returns the sum
 * as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 *
 * @author Yashraj R. Sontakke
 */
public class AddingNodes_2_5 {

    public LinkedList addList(LinkedList list1, LinkedList list2){
        String first = "";
        Node node = list1.getFirst();

        while (node!=null){
            first = node.getData().toString().concat(first);
            node = node.getNext();
        }

        String second = "";
        node = list2.getFirst();

        while (node!=null){
            second = node.getData().toString().concat(second);
            node = node.getNext();
        }
        if (first.isEmpty() && second.isEmpty()){
            return null;
        }else if(first.isEmpty()){
            return list2;
        }else if (second.isEmpty()){
            return list1;
        }

        Long result = Long.parseLong(first) + Long.parseLong(second);
        String sum = result.toString();

//        LinkedList output = new LinkedList(Long.parseLong(Character.toString(sum.charAt(sum.length()-1))));
//        for (int i = sum.length()-2;i>=0;i--){
//            output.appendToTail(Long.parseLong(Character.toString(sum.charAt(i))));
//        }


        LinkedList output = null;
        while (result > 0){
            if (output == null){
                output = new LinkedList(result %10);
            }else{
                output.appendToTail(result%10);
            }
            result = result/10;
        }
//
//        for (int i = sum.length()-2;i>=0;i--){
//            output.appendToTail(Long.parseLong(Character.toString(sum.charAt(i))));
//        }

        return output;
    }

    public static void main(String[] args){
        LinkedList list1 = new LinkedList(7L);
        list1.appendToTail(1L);
        list1.appendToTail(6L);

        LinkedList list2 = new LinkedList(5L);
        list2.appendToTail(9L);
        list2.appendToTail(2L);

        AddingNodes_2_5 addingNodes = new AddingNodes_2_5();
        LinkedList list = addingNodes.addList(list1, list2);
        list.printData();
    }
}
