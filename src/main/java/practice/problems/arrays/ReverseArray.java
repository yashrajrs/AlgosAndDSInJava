package practice.problems.arrays;

import java.util.Arrays;

/**
 * Write a program to reverse an array
 *
 * @author Yashraj R. Sontakke
 */
public class ReverseArray {

    public void reverse(Integer[] a){
        if (a == null || a.length < 2){
            return;
        }
        int begin = 0;
        int end = a.length-1;
        while (begin < end){
            int temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;
            begin++;
            end--;
        }
    }


    public static void main(String[] args){
        ReverseArray r = new ReverseArray();
        Integer[] a = {1,2,3,4};
        r.reverse(a);
        System.out.println(Arrays.asList(a).toString());

        Integer[] b = {1,2,3,4,5};
        r.reverse(b);
        System.out.println(Arrays.asList(b).toString());
    }
}
