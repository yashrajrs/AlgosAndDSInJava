package practice.problemSolving.string;

import practice.dataStructures.stack.*;
import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;
import practice.otherProblems.ListNode;

import java.util.*;
import java.util.Stack;

/**
 * Created by yashraj on 9/4/18.
 */
public class Testing {


    public void test() {
        List<Integer> list = new ArrayList<>();
        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int i=2;i<=2500;i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;
        node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                break;
            }

            node.next = node.next.next;
            node = node.next;
        }
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        Testing s = new Testing();
        s.test();
//        List<List<Integer>> result = s.generate(5);
//        print(result);
    }



}
