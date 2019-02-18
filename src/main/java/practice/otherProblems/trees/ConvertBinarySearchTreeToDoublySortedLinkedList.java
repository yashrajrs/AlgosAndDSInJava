package practice.otherProblems.trees;

import practice.otherProblems.strings.RandomSentenceGenerator;

import java.util.Stack;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

 Let's take the following BST as an example, it may help you understand the problem better:





 We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

 The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.





 Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

 The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.



 */
public class ConvertBinarySearchTreeToDoublySortedLinkedList {
    public Node treeToDoublyList(Node root) {
        Node first = null;
        Node last = null;
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null || !stack.isEmpty()) {
            if(p!=null) {
                stack.push(p);
                p = p.left;
            } else if (!stack.isEmpty()) {
                Node t = stack.pop();
                if(first == null) {
                    first = t;
                    last = t;
                } else {
                    last.right = t;
                    t.left = last;
                    last = last.right;
                }
                p = t.right;
            }
        }
        if(last != null ) {
            last.right = first;
        }
        if(first != null) {
            first.left = last;
        }
        return first;
    }

    public static void main(String[] args){
        ConvertBinarySearchTreeToDoublySortedLinkedList c = new ConvertBinarySearchTreeToDoublySortedLinkedList();

        //      4
        //     /  \
        //    2    5
        //   / \
        //  1   3
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);

        Node node2 = new Node(2, node1, node3);

        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, node2, node5);

        c.treeToDoublyList(node4);


    }

}
