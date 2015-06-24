package practice.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/14/15
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class Solution {

    public void printFizzBuzz(int n){
        if (n == 0){
            return;
        }
        for (int i=1;i<=n;i++){
            if (i%3 == 0 && i%5==0){
                System.out.println("FizzBuzz");
            }else if (i%5==0){
                System.out.println("Buzz");
            }else if (i%3==0){
                System.out.println("Fizz");
            }else{
                System.out.println(i);
            }
        }
    }


    static int numberOfPaths(int [][]a,int M,int N) {
        if (a[0][0] == 0 || a[M - 1][N - 1] == 0) {
            return 0;
        }
        int[][] table = new int[M][N];
        for (int i = 0; i < M; i++) {
            if (a[i][0] == 0) {
                break;
            }
            table[i][0] = 1;
        }
        for (int j = 0; j < N; j++) {
            if (a[0][j] == 0) {
                break;
            }
            table[0][j] = 1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (a[i][j] == 0) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
                }
            }
        }
        int ans = table[M - 1][N - 1] % (int)(Math.pow(10, 9) + 7);
        return ans;
    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Solution s = new Solution();
//        Scanner in = new Scanner(System.in);
//        Integer input;
//        input = in.nextInt();
//        s.printFizzBuzz(input);

        int[][] a = {{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(numberOfPaths(a,3,4));

        int[][] b = {{1,1},{0,1}};
        System.out.println(numberOfPaths(b,2,2));

    }
}
