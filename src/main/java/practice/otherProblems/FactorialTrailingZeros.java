package practice.otherProblems;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author Yashraj R. Sontakke
 */
public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        if(n<=0){
            return 0;
        }
        int result = 0;
        while(n>0){
            result += n/5;
            n /= 5;
        }
        return result;
    }

    public static void main(String[] args){
        FactorialTrailingZeros f = new FactorialTrailingZeros();
        System.out.println(f.trailingZeroes(5));
        System.out.println(f.trailingZeroes(7));
        System.out.println(f.trailingZeroes(10));
        System.out.println(f.trailingZeroes(20));
    }
}
