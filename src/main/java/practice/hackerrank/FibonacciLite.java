package practice.hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/14/15
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class FibonacciLite {


    public static void findFibonacci(Long n){
        Long prev =0L;
        Long current =1L;
        if (n==0 || n==1){
            System.out.println(n);
            return;
        }
        for(int i=0;i<n;i++){
            current = current +prev;
            prev = current - prev;
       }
        System.out.println(prev);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long a;
        a = in.nextLong();


        findFibonacci(a);
    }
}
