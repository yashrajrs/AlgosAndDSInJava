package practice.problems.others;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Find all the factors of a number
 *
 * @author Yashraj R. Sontakke
 */
public class FindFactorial {

    public Set<ArrayList<Integer>> factors = Sets.newHashSet();

    public void getFactors(int currentValue, int input, ArrayList<Integer> currentFactors) {
        if (currentValue >= input) {
            if (currentFactors.size() == 1) {
                currentFactors.add(1);
            }
            factors.add(currentFactors);
            return;
        }
        for (int i = 2; i <= input; i++) {
            if (input % (currentValue * i) == 0) {
                ArrayList<Integer> newFactors = new ArrayList<Integer>(currentFactors);
                newFactors.add(i);
                getFactors(currentValue * i, input, newFactors);
            }
        }
    }

    public void factorial(int currentValue, int input, ArrayList<Integer> currentFactors, Set<ArrayList<Integer>> factorials){
        if (currentValue >= input){
            if (currentFactors.size()==1){
                currentFactors.add(1);
            }
            factorials.add(currentFactors);
            return;
        }

        for (int i=2;i<=input;i++){
            if (input% (currentValue*i) == 0){
                ArrayList<Integer> newFactors = new ArrayList<Integer>(currentFactors);
                newFactors.add(i);
                factorial(currentValue*i, input, newFactors, factorials);
            }
        }
    }

    public List<List<Integer>> findFactorial(int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n==0){
            return result;
        }else if(n==1){
            result.add(Arrays.asList(1));
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        findFactorial(n, 1, list, result);
        return result;
    }

    public void findFactorial(int n, int val, ArrayList<Integer> list,List<List<Integer>> result ){
        if (n == val){
            if (list.size() == 1){
                list.add(1);
            }
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (val > n){
            return;
        }
        for (int i=2; i<=n; i++){
            if (n %(val*i) == 0){
                list.add(i);
                findFactorial(n, val*i, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {

        FindFactorial factorial = new FindFactorial();
        factorial.getFactors(1, 12, new ArrayList<Integer>());

        System.out.println(factorial.factors.toString());

        Set<ArrayList<Integer>> factorials = Sets.newHashSet();
        factorial.factorial(1,12,new ArrayList<Integer>(),factorials);

        System.out.println(factorials.toString());


        System.out.println(factorial.findFactorial(12).toString());

    }
}
