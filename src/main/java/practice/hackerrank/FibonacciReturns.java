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
public class FibonacciReturns {

    static int[] map = new int[50];

    public static void fibo(Integer n){
        System.out.println(findFibonacci(n));
    }

    public static Integer findFibonacci(Integer n){
        if (n == 0 || n==1){
            return n;
        }else if (map[n] > 0){
            return map[n];
        }else{
            map[n] = findFibonacci(n-1) + findFibonacci(n-2);
            return map[n];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a;
        while (true){
            a = in.nextLine();
            if (a.isEmpty()){
                break;
            }
            fibo(Integer.parseInt(a));
        }

    }
}
