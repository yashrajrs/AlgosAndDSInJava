package practice.problemSolving.string;

import java.util.Collections;
import java.util.HashMap;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * @author Yashraj R. Sontakke
 */
public class StringPermutation_1_3 {


    public void isPermutation(String string1, String string2) {
        if (string1 == null || string1.trim().length() == 0 || string2 == null || string2.trim().length() == 0) {
            System.out.println(" Input String is null / empty /blank");
            return;
        }
        HashMap<Character, Integer> hashMap = new HashMap();
        for (char c : string1.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }
        for (char c : string2.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                System.out.println(String.format("%s is not a permutation of %s", string1, string2));
                return;
            } else {
                int count = hashMap.get(c);
                if (count == 0) {
                    System.out.println(String.format("%s is not a permutation of %s", string1, string2));
                    return;
                } else {
                    hashMap.put(c, count - 1);
                }
            }
        }
        if (Collections.max(hashMap.values()) !=0){
            System.out.println(String.format("%s is not a permutation of %s", string1, string2));
            return;
        }
        System.out.println(String.format("%s is a permutation of %s", string1, string2));
    }

    public static void main(String[] args) {
        StringPermutation_1_3 s = new StringPermutation_1_3();
        s.isPermutation("MY NAME IS YASHRAJ", "NAME");
        s.isPermutation("MY NAME IS YASHRAJ", "ABCD");
        s.isPermutation("MY NAME IS YASHRAJ", "MYSJ");

//        s.isPermutation("ABCD");
//        s.isPermutation(null);
//        s.isPermutation("");
//        s.isPermutation("  ");
    }
}
