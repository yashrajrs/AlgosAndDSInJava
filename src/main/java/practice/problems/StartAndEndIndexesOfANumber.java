package practice.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted integer array and a number, find the start and end indexes of the number in the array.
 * <p/>
 * Ex1: Array = {0,0,2,3,3,3,3,4,7,7,9} and Number = 3 --> Output = {3,6}
 * Ex2: Array = {0,0,2,3,3,3,3,4,7,7,9} and Number = 5 --> Output = {-1,-1}
 * <p/>
 * Complexity should be less than O(n)
 *
 * @author Yashraj R. Sontakke
 */
public class StartAndEndIndexesOfANumber {

    public List<Integer> getIndexes(List<Integer> input, int number) {
        int start = -1;
        int end = -1;
        boolean started = false;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == number && !started) {
                started = true;
                start = i;
            } else if (input.get(i) != number && started) {
                end = i - 1;
                started = false;
            }

        }
        return Arrays.asList(start, end);
    }

    public static void main(String[] args) {
        StartAndEndIndexesOfANumber startAndEndIndexesOfANumber = new StartAndEndIndexesOfANumber();
        List<Integer> output1 = startAndEndIndexesOfANumber.getIndexes(Arrays.asList(0, 0, 2, 3, 3, 3, 3, 4, 7, 7, 9), 3);
        System.out.println(String.format("{%d, %d}", output1.get(0), output1.get(1)));

        List<Integer> output2 = startAndEndIndexesOfANumber.getIndexes(Arrays.asList(0, 0, 2, 3, 3, 3, 3, 4, 7, 7, 9), 5);
        System.out.println(String.format("{%d, %d}", output2.get(0), output2.get(1)));

    }
}
