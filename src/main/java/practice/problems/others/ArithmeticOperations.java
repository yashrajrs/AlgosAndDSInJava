package practice.problems.others;

/**
 * Write a function that adds two numbers. You should not use + or any arithmetic
 * operators.
 *
 * @author Yashraj R. Sontakke
 */
public class ArithmeticOperations {

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    public int subtract(int a, int b) {
        return add(a, ~b) + 1;
    }

    public int multiply(int a, int b) {
        if (b == 0) {
            return 0;
        }

        if (b > 0) {
            return a + multiply(a, b - 1);
        }

        return -multiply(a, -b);
    }

    public int multiply1(int a, int b) {
        boolean negativeB = false;
        if (b < 0) {
            b = ~b;
            negativeB = true;
        }
        int multiply = 0;
        for (int i = 0; i < b; i++) {
            multiply = add(multiply, a);
        }
        if (negativeB) {
            return ~multiply;
        }
        return multiply;
    }

    public int divide(int a, int b) {
        if (a < b) {
            return 0;
        }
        return 1 + divide(a - b, b);
    }


    public int divide1(int a, int b) {
        if (a < b) {
            return 0;
        }
        return 1 + divide(add(a, ~b) + 1, b);
    }


    public static void main(String[] args) {
        ArithmeticOperations addTwoNumbers = new ArithmeticOperations();
        System.out.println(addTwoNumbers.add(500, 441));
        System.out.println(addTwoNumbers.subtract(500, 440));
        System.out.println(addTwoNumbers.multiply(5, 4));
        System.out.println(addTwoNumbers.multiply1(5, 4));

        System.out.println(addTwoNumbers.divide(20, 4));
        System.out.println(addTwoNumbers.divide1(24, 4));
    }
}
