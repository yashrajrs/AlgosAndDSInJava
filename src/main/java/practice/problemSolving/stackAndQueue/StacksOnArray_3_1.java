package practice.problemSolving.stackAndQueue;

/**
 * Describe how you could use a single array to implement three stacks.
 *
 * @author Yashraj R. Sontakke
 */
public class StacksOnArray_3_1 {

    private final int stack1_start;
    private final int stack2_start;
    private final int stack3_start;
    private final int stack3_end;
    private Integer[] array;

    public StacksOnArray_3_1(int size) {
        array = new Integer[size];
        stack1_start = 0;
        stack2_start = size / 3;
        stack3_start = 2 * size / 3;
        stack3_end = size - 1;
    }

    public void push(int stackNo, Integer data) {
        switch (stackNo) {
            case 0:
                push(stack1_start, stack2_start - 1, data);
                break;
            case 1:
                push(stack2_start, stack3_start - 1, data);
                break;
            case 2:
                push(stack3_start, stack3_end, data);
                break;
            default:
                break;
        }
    }

    public void push(int start, int end, Integer data) {
        if (array[end] != null) {
            System.out.println("Stack is full. Cannot push");
            return;
        }
        for (int i = end; i > start; i--) {
            array[i] = array[i - 1];
        }
        array[start] = data;
    }

    public void pop(int stackNo) {
        switch (stackNo) {
            case 0:
                pop(stack1_start, stack2_start - 1);
                break;
            case 1:
                pop(stack2_start, stack3_start - 1);
                break;
            case 2:
                pop(stack3_start, stack3_end);
                break;
            default:
                break;
        }
    }

    public Integer pop(int start, int end) {
        if (array[start] == null) {
            System.out.println("Stack is empty. Cannot pop");
            return null;
        }
        int data = array[start];
        for (int i = start; i < end; i++) {
            array[i] = array[i + 1];
        }
        array[end] = null;
        return data;
    }

    public void printStack(int stackNo) {
        switch (stackNo) {
            case 0:
                System.out.println("Printing stack " + stackNo);
                printStack(stack1_start, stack2_start - 1);
                break;
            case 1:
                System.out.println("Printing stack " + stackNo);
                printStack(stack2_start, stack3_start - 1);
                break;
            case 2:
                System.out.println("Printing stack " + stackNo);
                printStack(stack3_start, stack3_end);
                break;
            default:
                break;
        }
    }

    public void printStack(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] == null) {
                break;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StacksOnArray_3_1 s = new StacksOnArray_3_1(9);
        s.push(0, 1);
        s.push(0, 2);
        s.push(0, 3);
        s.push(0, 4);
        s.printStack(0);

        s.push(1, 4);
        s.push(1, 5);
        s.push(1, 6);
        s.printStack(1);

        s.push(2, 7);
        s.push(2, 8);
        s.push(2, 9);
        s.printStack(2);

        s.pop(0);
        s.pop(0);
        s.pop(0);
        s.pop(0);
        s.pop(2);
        s.printStack(0);
        s.printStack(1);
        s.printStack(2);

    }
}
