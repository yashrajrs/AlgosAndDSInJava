package practice.problemSolving.stackAndQueue;

import practice.dataStructures.stack.Stack;

/**
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy
 * the elements into any other data structure (such as an array)
 *
 * @author Yashraj R. Sontakke
 */
public class SortStack_3_6 {

    public void sortStack(Stack s1){
        Stack s2 = new Stack();
        while (!s1.isEmpty()){
            Integer temp = (Integer) s1.pop();
            while (!s2.isEmpty() && (Integer)s2.peek() < temp){
                s1.push(s2.pop());
            }
            s2.push(temp);
        }
        s2.printStack();
    }
    public static void main(String[] args){
        SortStack_3_6 s = new SortStack_3_6();
        Stack s1 = new Stack();
        s1.push(4);
        s1.push(9);
        s1.push(3);
        s1.push(5);
        s1.push(15);
        s1.push(2);
        s1.push(8);

        s.sortStack(s1);
    }
}
