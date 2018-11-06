package practice.problems.others;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/8/15
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class LeastNumberPerfectSquare {

    ArrayList<Integer> leastNumber = new ArrayList<Integer>();

    public void getLeastNumber(int input, int currentValue, ArrayList<Integer> currentNumber){
        if (currentValue == input){
            if (leastNumber.isEmpty() || currentNumber.size() < leastNumber.size()){
                leastNumber = currentNumber;
            }
            return;
        }
        if (currentValue > input){
            return;
        }
        for (int i=1;i<=input/2;i++){
            if (currentValue + i*i <= input){
                ArrayList<Integer> number = new ArrayList<Integer>(currentNumber);
                number.add(i*i);
                getLeastNumber(input, currentValue + i*i, number);
            }
        }
    }

    public static void main(String[] args){
        LeastNumberPerfectSquare l = new LeastNumberPerfectSquare();

        l.getLeastNumber(12, 0, new ArrayList<Integer>());
        System.out.println(l.leastNumber.toString());

        l.leastNumber = new ArrayList<Integer>();
        l.getLeastNumber(6, 0, new ArrayList<Integer>());
        System.out.println(l.leastNumber.toString());
    }
}
