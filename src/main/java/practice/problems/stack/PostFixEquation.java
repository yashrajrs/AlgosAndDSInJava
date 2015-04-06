package practice.problems.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Evaluate postfix equation.
 * * <p>Some sample ops and their results:
 * ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5
 * ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) -> 7
 *
 * @author Yashraj R. Sontakke
 */
public class PostFixEquation {

    public void calculate(String[] list){
        Stack<Double> stack = new Stack<Double>();

        for (String string:list){
            if (!isOperation(string)){
                stack.push(Double.parseDouble(string));
            }else if (stack.isEmpty()){
                throw  new IllegalStateException("Wrong input");
            }else{
                Double number2 = stack.pop();
                if (stack.isEmpty()){
                    throw  new IllegalStateException("Wrong input");
                }
                Double number1 = stack.pop();

                Double value = getValue(number1,number2,string);
                stack.push(value);
            }
        }
        if (stack.isEmpty()){
            throw  new IllegalStateException("Wrong input");
        }
        Double value = stack.pop();
        if (!stack.isEmpty()){
            throw  new IllegalStateException("Wrong input");
        }
        System.out.println(value);


    }

    public Double getValue(Double number1, Double number2, String operation){
        if ("+".equals(operation)){
            return number1+number2;
        }else if ("-".equals(operation)){
            return number1-number2;
        }else if ("*".equals(operation)){
            return number1*number2;
        }else if ("/".equals(operation)){
            return number1/number2;
        }else{
            throw  new IllegalStateException("Wrong input");
        }
    }

    public boolean isOperation(String input){
        return "+".equals(input) || "-".equals(input) ||
                "*".equals(input) || "/".equals(input);
    }


    public static void main(String[] args){
        PostFixEquation postFixEquation = new PostFixEquation();
        String[] input1 = {"4", "1", "+", "2.5", "*"};
        postFixEquation.calculate(input1);

        String[] input2 = {"5", "80", "40", "/", "+"};
        postFixEquation.calculate(input2);
    }

}
