package practice.hackerrank;

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
public class FizzBuzz {

    public static void printFizzBuzz(int n){
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

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        Integer input;
        input = in.nextInt();
        printFizzBuzz(input);


    }
}
