package practice.otherProblems;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author Yashraj R. Sontakke
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int x = 0;
        for(int a : A){
            x = x ^ a;
        }
        return x;
    }


    public static void main(String[] args){
        SingleNumber s = new SingleNumber();
        int[] a = {1,2,3,3,1};
        System.out.println(s.singleNumber(a));
    }
}
