package practice.problemSolving.stackAndQueue;

import practice.dataStructures.stack.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 *
 * @author Yashraj R. Sontakke
 */
public class MyQueue_3_5 {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void enqueue(Integer data){
        stack1.push(data);
    }

    public void shuffleStacks(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public Integer dequeue(){
        if (stack2.isEmpty()){
            shuffleStacks();
        }
        return (Integer) stack2.pop();
    }



    public Integer peek(){
        if (stack2.isEmpty()){
            shuffleStacks();
        }
        return (Integer)stack2.peek();
    }

    public static void main(String[] args){
        MyQueue_3_5 m = new MyQueue_3_5();
        m.enqueue(10);
        m.enqueue(20);
        m.enqueue(30);
        System.out.println(m.dequeue());
        System.out.println(m.dequeue());
    }
}
