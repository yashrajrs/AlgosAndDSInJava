package practice.problems.stack;

import practice.dataStructures.stack.Stack;

/**
 * Converts input infix expression to postfix expression.
 *
 * @author Yashraj R. Sontakke
 */
public class InfixToPostFix {

    public String convert(String input) {
        Stack stack = new Stack();
        String output = "";

        int i = 0;
        while (i < input.length()) {
            Character current = input.charAt(i);
            if (current != '+' && current != '-' && current != '*' && current != '/') {
                output = output + current;
            } else if (stack.isEmpty()) {
                stack.push(current);
            } else {
                while (!stack.isEmpty() && getValue(current) <= getValue((Character) stack.peek())) {
                    Character topElement = (Character) stack.pop();
                    output = output + topElement;
                }
                stack.push(current);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            Character topElement = (Character) stack.pop();
            output = output.concat(Character.toString(topElement));
        }
        return output;
    }

    public Integer getValue(Character input) {
        switch (input) {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                throw new IllegalStateException("Bad input");
        }

    }

    public static void main(String[] args) {
        InfixToPostFix i = new InfixToPostFix();
//        System.out.println(i.convert("A+B"));
        System.out.println(i.convert("a+b*c-d"));

    }
}
