package practice.problems;

/**
 * Finds the square root for a given number.
 *
 * @author Yashraj R. Sontakke
 */
public class SquareRoot {

    public Float getSquareRoot(int n) {
        float low = 0;
        float high = n;
        float mid = (low + high) / 2;
        while (Math.abs((mid * mid) - n) > 0.00001) {
            if (mid * mid > n) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(String.format("Square root of %d = %.2f", 9, squareRoot.getSquareRoot(9)));
        System.out.println(String.format("Square root of %d = %.2f", 8, squareRoot.getSquareRoot(8)));
    }
}
