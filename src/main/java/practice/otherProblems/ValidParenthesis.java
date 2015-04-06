package practice.otherProblems;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.

 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * @author Yashraj R. Sontakke
 */
public class ValidParenthesis {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()){
            if(isOpenBracket(c)){
                stack.push(c);
            }else if(isClosedBracket(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(!isValidBracket(stack.pop(),c)){
                    return false;
                }
            }else{
                return false;
            }

        }
        return stack.isEmpty();
    }

    public boolean isOpenBracket(Character c){
        return c == '(' || c == '[' || c== '{';
    }

    public boolean isClosedBracket(Character c){
        return c == ')' || c == ']' || c== '}';
    }

    public boolean isValidBracket(Character c1, Character c2){
        if(c1 == '(' && c2 == ')'){
            return true;
        }
        if(c1 == '{' && c2 == '}'){
            return true;
        }
        if(c1 == '[' && c2 == ']'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        ValidParenthesis v = new ValidParenthesis();
        System.out.println(v.isValid("()"));
        System.out.println(v.isValid("()[]{}"));
        System.out.println(v.isValid("(]"));
        System.out.println(v.isValid("([)]"));
        System.out.println(v.isValid("(()"));

    }
}
