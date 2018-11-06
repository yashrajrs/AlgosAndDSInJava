package practice.otherProblems.strings;

import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * 1 "123"
 * 2 "132"
 * 3 "213"
 * 4 "231"
 * 5 "312"
 * 6 "321"
 * Given n and k, return the kth permutation sequence.
 * <p/>
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * @author Yashraj R. Sontakke
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k--;

        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        String result = "";

        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int curIndex = k / mod;
            k = k % mod;

            result += list.get(curIndex);
            list.remove(curIndex);

        }
        return result;
    }

    public static void main(String[] args){
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(3, 6));
    }
}
