package practice.otherProblems;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author Yashraj R. Sontakke
 */
public class SingleNumber2 {

    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for(int i=0;i<A.length;i++){
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args){
        SingleNumber2 s = new SingleNumber2();
        int[] a = {1,2,3,3,1,1,3};
        System.out.println(s.singleNumber(a));
    }
}
