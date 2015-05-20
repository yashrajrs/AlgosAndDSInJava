package practice.hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/14/15
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class FactorialOfN {

    public static void findFactorial(int n){
        if (n <0){
            return;
        }
        if (n==0){
            System.out.println(1);
            return;
        }
        Long factorial = 1L;
        for (int i=n;i>=1;i--){
            factorial *= i;
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        Integer input;
        input = in.nextInt();
        findFactorial(input);


    }
}
