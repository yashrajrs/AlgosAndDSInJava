package practice.problems;

import com.google.common.collect.Sets;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        FindFactorial factorial = new FindFactorial();
        factorial.getFactors(1, 12, new ArrayList<Integer>());

        System.out.println(factorial.factors.toString());
    }
}
