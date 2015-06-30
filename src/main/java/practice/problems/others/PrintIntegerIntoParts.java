package practice.problems.others;

import java.util.Stack;

/**
 * Print integer 123 as
 * 1
 * 2
 * 3
 * Without using standard character and string operations.
 *
 * @author Yashraj R. Sontakke
 */
public class PrintIntegerIntoParts {

    public void printIntegers(int input){
        if (input == 0){
            System.out.println(0);
            return;
        }
        int integer;
        Stack<Integer> stack = new Stack<Integer>();
        while (input > 0){
            integer = input %10;
            input = input / 10;
            stack.push(integer);

        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


    private void get(int a, int b){
       b = b+a;
       a = b-a;
       b = b -a;
       b = b -a;

        System.out.println(a);
        System.out.println(b);
    }


    public void printInParts(int input){
        if (input==0){
            System.out.println(input);
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (input > 0){
            stack.push(input%10);
            input/=10;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static  void main(String[] args){
        PrintIntegerIntoParts parts = new PrintIntegerIntoParts();
        parts.get(80,50);
    }
}
