package practice.problems;

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

    public static  void main(String[] args){
        PrintIntegerIntoParts parts = new PrintIntegerIntoParts();
        parts.printIntegers(123);
        System.out.println();
        parts.printIntegers(0);
        System.out.println();
        parts.printIntegers(5678);
    }
}
