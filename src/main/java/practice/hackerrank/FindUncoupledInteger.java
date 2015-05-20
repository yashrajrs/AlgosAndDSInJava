package practice.hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/14/15
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class FindUncoupledInteger {

    public static void findInteger(String input){
        String[] split = input.split(" ");
        if (split.length == 0){
            return;
        }
        if (split.length == 1){
            System.out.println(split[0]);
            return;
        }
        Integer integer = Integer.parseInt(split[0]);
        for (int i=1;i<split.length;i++){
            integer = integer ^ Integer.parseInt(split[i]);
        }
        System.out.println(integer);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        String input;
        input = in.nextLine();
        input = input.replace(",","");
        findInteger(input);


    }
}
