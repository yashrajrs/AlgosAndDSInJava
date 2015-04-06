package practice.problems.listsAndQueues;

import practice.dataStructures.linkedList.Node;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/31/15
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class StackWithMid {
    Node top,mid;
    int size;

    public void push(Integer data){
        Node newNode = new Node(data);
        if (top == null){
            top = newNode;
            mid = top;
            size = 1;
        }else{
            newNode.setNext(top);
            top.setPrev(newNode);
            top = newNode;
            size++;
            if (size%2!=0){
                mid = mid.getPrev();
            }
        }
    }

    public Integer pop(){
        if (top == null){
            return null;
        }
        if (size==1){
            Integer data = (Integer)top.getData();
            top = null;
            mid = null;
            size = 0;
            return data;
        }

        Integer data = (Integer)top.getData();
        top = top.getNext();
        top.setPrev(null);
        size--;
        if (size%2==0){
            mid = mid.getNext();
        }
        return data;
    }

    public Integer getMid(){
        if (mid == null){
            return null;
        }
        return (Integer) mid.getData();
    }

    public Integer deleteMid(){
        if (mid==null){
            return null;
        }
        Integer data = (Integer) mid.getData();
        Node prev = mid.getPrev();
        Node next = mid.getNext();
        if (prev!=null){
            prev.setNext(next);
        }
        if (next!=null){
            next.setPrev(prev);
        }
        size--;
        if (size%2==0){
            mid = next;
        }else{
            mid = prev;
        }

        return data;
    }

    public void printStack(){
        Node n = top;
        while(n!=null){
            System.out.print(n.getData() + "  ");
            n = n.getNext();
        }
        System.out.println();

    }

    public static void main(String[] args){
        StackWithMid stack = new StackWithMid();
        stack.push(10);
        stack.printStack();
        System.out.println(stack.getMid());

        stack.push(20);
        stack.printStack();
        System.out.println(stack.getMid());

        stack.push(30);
        stack.printStack();
        System.out.println(stack.getMid());

        stack.push(40);
        stack.printStack();
        System.out.println(stack.getMid());

//        stack.pop();
//        stack.printStack();
//        System.out.println(stack.getMid());
//
//        stack.pop();
//        stack.printStack();
//        System.out.println(stack.getMid());
//
//        stack.pop();
//        stack.printStack();
//        System.out.println(stack.getMid());

        stack.deleteMid();
        stack.printStack();
        System.out.println(stack.getMid());

        stack.deleteMid();
        stack.printStack();
        System.out.println(stack.getMid());
    }
}
