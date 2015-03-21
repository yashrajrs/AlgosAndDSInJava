package practice.dataStructures.stack;

import practice.dataStructures.Node;

/**
 * Implements a stack.
 *
 * @author Yashraj R. Sontakke
 */
public class Stack {
    public Node top;

    public void push(final Object d){
        Node n = new Node(d);
        n.next = top;
        top = n;
    }

    public Object pop(){
        if(top != null){
            Object d = top.data;
            top = top.next;
            return d;
        }
        return null;
    }

    public Object peek(){
        if(top == null){
            return null;
        }
        return top.data;
    }

    public void printStack(){
        Node n = top;
        System.out.println("Printing stack");
        while(n!=null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.printStack();
        s.pop();
        s.pop();
        s.printStack();

    }
}
