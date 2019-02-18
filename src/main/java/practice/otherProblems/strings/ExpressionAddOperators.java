package practice.otherProblems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Example 1:

 Input: num = "123", target = 6
 Output: ["1+2+3", "1*2*3"]
 Example 2:

 Input: num = "232", target = 8
 Output: ["2*3+2", "2+3*2"]
 Example 3:

 Input: num = "105", target = 5
 Output: ["1*0+5","10-5"]
 Example 4:

 Input: num = "00", target = 0
 Output: ["0+0", "0-0", "0*0"]
 Example 5:

 Input: num = "3456237490", target = 9191
 Output: []

 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> result = new ArrayList<>();

        if (num.length() == 0) {
            return result;
        }
        getResult(num, 0, 0, new StringBuilder(),0, result, target);
        return result;
    }

    public void getResult(String num, int index, long value, StringBuilder ops, long previousValue, List<String> result, int target) {
        if (index == num.length()) {
            if (value == target) {
                result.add(ops.toString());
            }
            return;
        }
        long currentVal = 0;
        String currentValRep = null;
        int length = num.length();

        for (int i=index;i<length;i++) {

            //Operand
            currentVal = currentVal*10 + Character.getNumericValue(num.charAt(i));
            currentValRep = Long.toString(currentVal);

            if (index == 0) {
                getResult(num, i + 1, currentVal, new StringBuilder(ops.toString()).append(currentValRep),
                        currentVal, result, target);
            } else {
                long v = value - previousValue;

                //MULTIPLY
                getResult(num, i + 1, v + (previousValue*currentVal), new StringBuilder(ops.toString()).append('*').append(currentValRep),
                        previousValue*currentVal, result, target);

                //ADD
                getResult(num, i + 1, v + currentVal, new StringBuilder(ops.toString()).append('+').append(currentValRep),
                        currentVal, result, target);

                //SUBTRACT
                getResult(num, i + 1, v - currentVal, new StringBuilder(ops.toString()).append('-').append(currentValRep),
                        -currentVal, result, target);

            }
            if (num.charAt(index) == '0') {
                break;
            }
        }

    }
    public List<String> getOperators1(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }

        getValues1(s, target, "", 0, 0);
        return null;
    }

    public void getValues1(String s, int target, String temp, int prevVal, int curVal) {
        if (s.length() == 0) {
            return;
        }
        Integer currentNumber = (int) (s.charAt(0) - '0');
        getValues1(s.substring(1), target, temp + currentNumber + '+', curVal, curVal + currentNumber);
    }

    public List<String> getOperators(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        List<String> operandValues = new ArrayList<>();
        getValues(s, operandValues, "", 0, 0);
        for (String current: operandValues) {
            if (getValue(current) == target) {
                result.add(current);
            }
        }
        return result;
    }

    public int getValue(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.push(s.charAt(i) - '0');
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if (s.charAt(i) == '+') {
                    stack.push(num1+num2);
                } else if (s.charAt(i) == '-') {
                    stack.push(num1-num2);
                } else {
                    stack.push(num1*num2);
                }
            }
        }
        return stack.pop();
    }

    public void getValues(String s, List<String> operandValues, String temp, int prevVal, int curVal) {
//        if(s.length() == 1) {
//            operandValues.add(new String( temp + s));
//            return;
//        }
        if (s.length()==0) {
            return;
        }
        getValues(s.substring(1), operandValues, temp + s.charAt(0) + "+",curVal ,curVal + (s.charAt(0) - '0'));
//        getValues(s.substring(1), operandValues, temp + s.charAt(0) + "-", curVal ,prevVal + curVal);

//        getValues(s.substring(1), operandValues, temp + s.charAt(0) + "*", cu);
    }


    public static void main(String[] args) {
        ExpressionAddOperators e  = new ExpressionAddOperators();
//        System.out.println(e.addOperators("123", 6)); // ["1+2+3", "1*2*3"]
//        System.out.println(e.addOperators("232", 8)); // ["2*3+2", "2+3*2"]
//        System.out.println(e.addOperators("105", 5)); // ["1*0+5","10-5"]
//        System.out.println(e.addOperators("00", 0)); // ["0+0", "0-0", "0*0"]
//        System.out.println(e.addOperators("3456237490", 9191)); // []


        System.out.println(e.getOperators1("123", 6)); // ["1+2+3", "1*2*3"]
        System.out.println(e.getOperators("232", 8)); // ["2*3+2", "2+3*2"]
        System.out.println(e.getOperators("105", 5)); // ["1*0+5","10-5"]
        System.out.println(e.getOperators("00", 0)); // ["0+0", "0-0", "0*0"]
        System.out.println(e.getOperators("3456237490", 9191)); // []
    }


}
