package practice.problemSolving.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
 * of n-pairs of parentheses
 *
 * @author Yashraj R. Sontakke
 */
public class Paranthesis_9_6 {

    public void addParenthesis(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
        if (leftRem<0 ||rightRem<leftRem){
            return;
        }
        if (leftRem==0 && rightRem==0){
            String s = String.copyValueOf(str);
            list.add(s);
        }else{
            if (leftRem >0){
                str[count] = '(';
                addParenthesis(list, leftRem-1, rightRem, str, count+1);
            }
            if (rightRem > leftRem){
                str[count] = ')';
                addParenthesis(list, leftRem, rightRem-1, str, count+1);
            }
        }
    }

    public ArrayList<String> getParens(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParenthesis(list, count, count, str,0);
        return list;
    }




    public static void main(String[] args) {
        Paranthesis_9_6 permutationsString = new Paranthesis_9_6();
        System.out.println(permutationsString.getParens(3).toString());
    }
}
