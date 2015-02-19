package practice.problems.arrays;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Calculates the result of the equation provided.
 *
 * @author Yashraj R. Sontakke
 */
public class CalculateEquation {


    public Double getValue(List<String> input) {
        Stack stack = new Stack();
        int i = 0;
        while (i < input.size()) {
            String string = input.get(i);
            if (NumberUtils.isNumber(string)) {
                stack.push(Double.valueOf(string));
                i++;
            } else if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
                if (stack.empty()) {
                    throw new IllegalStateException("Bad Input");
                }
                Double input1 = (Double) stack.pop();
                i++;
                if (!NumberUtils.isNumber(input.get(i))) {
                    throw new IllegalStateException("Bad Input");
                }
                Double input2 = Double.valueOf(input.get(i));
                i++;
                Double value = getValue(input1, input2, string);
                stack.push(value);
            } else {
                throw new IllegalStateException("Bad Input");
            }
        }

        if (stack.empty()) {
            throw new IllegalStateException("Bad Input");
        }
        return (Double) stack.pop();

    }

    public Double getValue(Double input1, Double input2, String operator) {
        if ("+".equals(operator)) {
            return input1 + input2;
        } else if ("-".equals(operator)) {
            return input1 - input2;
        } else if ("*".equals(operator)) {
            return input1 * input2;
        } else if ("/".equals(operator)) {
            return input1 / input2;
        } else {
            throw new IllegalStateException("Bad Input");
        }
    }

    public static void main(String[] args) {
        CalculateEquation c = new CalculateEquation();
        System.out.println(c.getValue(Arrays.asList("3", "+", "12", "*", "3", "-", "4", "/", "7")));
        System.out.println(c.getValue(Arrays.asList("A", "+", "12", "*", "3", "-", "4", "/", "7")));
    }

}
