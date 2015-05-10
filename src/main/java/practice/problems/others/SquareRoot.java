package practice.problems.others;

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


    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int left =1;
        int right = x/2;
        while(left <= right){
            int mid = (left + right)/2;
            if(x/mid == mid){
                return mid;
            }else if(x/mid > mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(String.format("Square root of %d = %.2f", 9, squareRoot.getSquareRoot(9)));
        System.out.println(String.format("Square root of %d = %.2f", 8, squareRoot.getSquareRoot(8)));
        System.out.println(String.format("Square root of %d = %d", 9, squareRoot.mySqrt(9)));
        System.out.println(String.format("Square root of %d = %d", 8, squareRoot.mySqrt(8)));

    }
}
