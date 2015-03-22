package practice.problems.others;

/**
 * Given an integer n, calculate square of a number without using *, / and pow().
 * Examples: Input: n = 5 Output: 25
 *
 * @author Yashraj R. Sontakke
 */
public class SquareOfANumber {

    public Integer getSquare(int n) {
        if (n < 0) {
            n = Math.abs(n);
        }
        int value = 0;
        for (int i = 0; i < n; i++) {
            value += n;
        }
        return value;
    }

    public static void main(String[] args) {
        SquareOfANumber squareOfANumber = new SquareOfANumber();
        System.out.println(String.format("Square of %d is %d", 5, squareOfANumber.getSquare(5)));
        System.out.println(String.format("Square of %d is %d", 4, squareOfANumber.getSquare(4)));
        System.out.println(String.format("Square of %d is %d", -4, squareOfANumber.getSquare(-4)));
    }
}
