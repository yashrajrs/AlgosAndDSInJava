package practice.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Calculates the array average.
 * @author Yashraj R. Sontakke
 */
public class ArrayAverage {

    public double findArrayAverage(final ArrayList<Integer> input){
        if (input.size() == 1){
            return input.get(0).doubleValue();
        }
        Double total = 0.0;
        for (Integer integer:input){
            total +=integer;
        }

        return  total/input.size();
    }

    public static void main(String[] args) {
        ArrayAverage arrayAverage = new ArrayAverage();

        final ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 4));

        System.out.println("Array Average is " + arrayAverage.findArrayAverage(input));

    }
}
