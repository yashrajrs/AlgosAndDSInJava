package practice.problemSolving.stackAndQueue;

import practice.dataStructures.Node;

/**
 * Stack with size
 *
 * @author Yashraj R. Sontakke
 */
public class StackWithSize {
    private Node top;
    private int size = 0;
    private StackWithSize next;

    public void setNext(StackWithSize next) {
        this.next = next;
    }

    public void push(Integer data){
        if (top == null){
            top = new Node(data);
            size = 1;
        }else{
            Node newNode = new Node(data);
            newNode.setNext(top);
            top = newNode;
            size++;
        }
    }

    public Node getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }

    public StackWithSize getNext() {
        return next;
    }

    public Integer pop(){
        if (size>0){
            Integer temp = (Integer) top.getData();
            top = top.getNext();
            size--;
            return temp;
        }
        return null;
    }

    public void printStack(){
        Node n = top;
        while (n != null){
            System.out.print(n.getData() + " ");
            n = n.getNext();
        }
    }
}
