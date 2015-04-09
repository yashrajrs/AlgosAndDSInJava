package practice.problems.others;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/8/15
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class SubSetSumOfANumber {

    public void findSubSet(int input, int currentValue, String subSet, Set<String> subSets){
        if (currentValue == input){
            subSets.add(subSet.toString());
            return;
        }
        if (currentValue > input){
            return;
        }
        for (int i=1;i<=input;i++){
            if (currentValue + i <= input){

                findSubSet(input, currentValue+i, subSet.concat(Integer.toString(i)),subSets);
            }
        }
    }

    public static void main(String[] args){
        SubSetSumOfANumber s = new SubSetSumOfANumber();
        Set<String> subSets = Sets.newHashSet();
        s.findSubSet(4,0,"",subSets);
        System.out.println(subSets.toString());

    }
}
