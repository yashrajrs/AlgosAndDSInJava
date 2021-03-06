package practice.otherProblems.bitwise;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.

 * For example, given the range [5, 7], you should return 4.
 *
 * @author Yashraj R. Sontakke
 */
public class BitwiseAndOfNumbersInRange {

    public int rangeBitwiseAnd(int m, int n) {
        while(n > m){
            n = n & n-1;
        }
        return m & n;
    }


    public static void main(String[] args){
        BitwiseAndOfNumbersInRange b = new BitwiseAndOfNumbersInRange();
        System.out.println(b.rangeBitwiseAnd(5, 7));
    }
}
