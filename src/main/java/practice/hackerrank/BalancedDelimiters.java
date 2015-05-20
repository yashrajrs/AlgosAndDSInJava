package practice.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 5/14/15
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class BalancedDelimiters {

    public static void check(String input){
        if (input == null || input.length() == 0){
            return;
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character c : input.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if (stack.isEmpty()){
                System.out.println("False");
                return;
            }else{
                Character character = stack.pop();
                if (!isValidClosingBracket(character, c)){
                    System.out.println("False");
                    return;
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println("True");
            return;
        }
        System.out.println("False");
    }

    private static boolean isValidClosingBracket(Character a, Character b){
        if (a== '(' && b==')'){
            return true;
        }else if (a=='{' && b == '}'){
            return true;
        }else if (a =='[' && b == ']'){
            return true;
        }
        return false;
    }

    public boolean isValid(String input){
        if (input==null || input.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character c : input.toCharArray()){
            if (c=='(' || c=='{'||c=='['){
                stack.push(c);
            }else if (stack.isEmpty()){
                return false;
            }else{
                Character character = stack.pop();
                if (!isValidDelimiter(character,c)){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }


    private boolean isValidDelimiter(Character a, Character b){
        if (a=='(' && b==')'){
            return true;
        }else if (a=='{' && b=='}'){
            return true;
        }else if (a=='[' && b==']'){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        String input;
        input = in.nextLine();
        check(input);


    }
}
