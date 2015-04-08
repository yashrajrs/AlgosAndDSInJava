package practice.otherProblems;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author Yashraj R. Sontakke
 */
public class ReversePolishEvaluate {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<Integer>();

        for (String string : tokens) {
            if (!operators.contains(string)) {
                stack.push(Integer.parseInt(string));
            } else {

                int number2 = stack.pop();
                int number1 = stack.pop();
                stack.push(getValue(number1, number2, string.charAt(0)));
            }
        }
        return stack.pop();
    }

    public Integer getValue(int number1, int number2, char operator) {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            default:
                return number1 / number2;
        }
    }

    public static void main(String[] args){
        ReversePolishEvaluate r = new ReversePolishEvaluate();
        String[] input1 = {"2", "1", "+", "3", "*"};
        String[] input2 =  {"4", "13", "5", "/", "+"};
        System.out.println(r.evalRPN(input1));
        System.out.println(r.evalRPN(input2));
    }
}
