package practice.otherProblems;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.

 Example 1:

 Input: dividend = 10, divisor = 3
 Output: 3
 Example 2:

 Input: dividend = 7, divisor = -3
 Output: -2
 Note:

 Both dividend and divisor will be 32-bit signed integers.
 The divisor will never be 0.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoNumbers {

    //The time complexity is O(logn).
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        long pDividend = Math.abs(dividend);
        long pDivisor = Math.abs(divisor);

        int result = 0;

        while (pDividend >= pDivisor) {
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }
            result += 1<<(numShift-1);
            pDividend -= pDivisor<<(numShift-1);
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 || divisor < 0)) {
            return result;
        }
        return -result;
    }

    public static void main(String[] args) {
        DivideTwoNumbers divideTwoNumbers = new DivideTwoNumbers();
        System.out.println(divideTwoNumbers.divide(10, 3));

        System.out.println(divideTwoNumbers.divide(7, -3));
    }
}
