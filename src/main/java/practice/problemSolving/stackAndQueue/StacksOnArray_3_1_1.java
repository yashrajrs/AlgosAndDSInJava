package practice.problemSolving.stackAndQueue;

/**
 * Describe how you could use a single array to implement three stacks.
 *
 * @author Yashraj R. Sontakke
 */
public class StacksOnArray_3_1_1 {

    private final int stack1Start, stack1End, stack2Start, stack2End, stack3Start, stack3End;
    private int stack1Top, stack2Top, stack3Top;

    private final int arraySize;
    private final int[] array;

    public StacksOnArray_3_1_1(int size){
        arraySize = size;
        array = new int[arraySize];
        stack1End = 0;
        stack1Start = arraySize/3-1;
        stack2End  = arraySize/3;
        stack2Start  = 2* arraySize/3 - 1;
        stack3End = 2 * arraySize/3;
        stack3Start = arraySize -1;
        stack1Top = stack1Start +1;
        stack2Top = stack2Start +1;
        stack3Top = stack3Start +1;
    }

    public void push( int stackNo,int data){
        switch (stackNo){
            case 0:
                if (stack1Top == stack1End){
                    System.out.println("Stack1 is full. Cannot add");
                    return;
                }
                stack1Top--;
                array[stack1Top] = data;
                break;
            case 1:
                if (stack2Top == stack2End){
                    System.out.println("Stack2 is full. Cannot add");
                    return;
                }
                stack2Top--;
                array[stack2Top] = data;
                break;
            case 2:
                if (stack3Top == stack3End){
                    System.out.println("Stack3 is full. Cannot add");
                    return;
                }
                stack3Top--;
                array[stack3Top] = data;
                break;
            default:
                System.out.println("Invalid stack. Cannot add");
        }
    }

    public Integer pop(int stackNo){
        Integer data = null;
        switch (stackNo){

            case 0:
                if (stack1Top == stack1Start+1){
                    System.out.println("Stack1 is empty. Cannot pop");
                    return data;
                }
                data = array[stack1Top];
                stack1Top++;
                return data;
            case 1:
                if (stack2Top == stack2Start+1){
                    System.out.println("Stack2 is empty. Cannot pop");
                    return data;
                }
                data = array[stack2Top];
                stack2Top++;
                return data;
            case 2:
                if (stack3Top == stack3Start+1){
                    System.out.println("Stack3 is empty. Cannot pop");
                    return data;
                }
                data = array[stack3Top];
                stack3Top++;
                return data;
            default:
                System.out.println("Invalid stack. Cannot pop");
                return data;

        }
    }

    public void printStack(int stackNo) {
        switch (stackNo){
            case 0:
               printStack(stack1Top,stack1Start);
                break;
            case 1:
                printStack(stack2Top,stack2Start);
                break;
            case 2:
                printStack(stack3Top,stack3Start);
                break;
            default:
                System.out.println("Invalid stack. Cannot print");
                break;

        }
    }

    public void printStack(int stackTop, int stackStart){
        if (stackTop==stackStart+1){
            System.out.println("Stack is empty");
            return;
        }

        for (int i = stackTop; i<=stackStart;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StacksOnArray_3_1_1 s = new StacksOnArray_3_1_1(9);
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

