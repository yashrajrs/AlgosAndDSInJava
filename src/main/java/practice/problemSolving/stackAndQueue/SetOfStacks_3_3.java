package practice.problemSolving.stackAndQueue;

/**
 * Implement sets of stacks of size.
 *
 * @author Yashraj R. Sontakke
 */
public class SetOfStacks_3_3 {

    StackWithSize topStack;
    int size;

    public SetOfStacks_3_3(int size) {
        this.size = size;
    }

    public void push(Integer data) {
        if (topStack == null) {
            topStack = new StackWithSize();
            topStack.push(data);
        } else if (topStack.getSize() < size) {
            topStack.push(data);
        } else {
            StackWithSize newStack = new StackWithSize();
            newStack.push(data);
            newStack.setNext(topStack);
            topStack = newStack;
        }

    }

    public Integer pop() {
        if (topStack == null) {
            return null;
        } else if (topStack.getSize() == 1) {
            Integer d = topStack.pop();
            topStack = topStack.getNext();
            return d;
        } else {
            return topStack.pop();
        }
    }

    public Integer popAt(int stackNo) {
        StackWithSize stackWithSize = topStack;
        for (int i = 0; i < stackNo - 2; i++) {
            if (stackWithSize == null) {
                System.out.println("Invalid stack to pop");
                return null;
            }
            stackWithSize = stackWithSize.getNext();
        }
        StackWithSize stack = stackWithSize.getNext();
        if (stack == null) {
            System.out.println("Invalid stack to pop");
            return null;
        }

        if (stack.getSize() == 1) {
            Integer d = stack.pop();
            stackWithSize.setNext(stack.getNext());
            return d;
        } else {
            return stack.pop();
        }
    }

    public void printStack() {
        StackWithSize stackWithSize = topStack;
        while (stackWithSize != null) {
            System.out.print("{");
            stackWithSize.printStack();
            System.out.print("}");
            stackWithSize = stackWithSize.getNext();
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SetOfStacks_3_3 s = new SetOfStacks_3_3(3);
        s.push(10);
        s.push(11);
        s.push(12);
        s.printStack();
        s.push(20);
        s.printStack();
        s.push(21);
        s.push(22);
        s.printStack();
        s.push(30);
        s.printStack();
        s.pop();
        s.printStack();
        s.pop();
        s.pop();
        s.printStack();

        s.push(21);
        s.push(22);

        s.push(30);
        s.push(31);
        s.push(32);
        s.printStack();

        s.popAt(2);
        s.printStack();
        s.popAt(2);
        s.printStack();
        s.popAt(2);
        s.printStack();


    }

}
