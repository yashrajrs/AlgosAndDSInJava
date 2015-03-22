package practice.problems.others;

import java.util.Arrays;

/**
 * Write a method to randomly generate a set of m integers from an array of size n.
 * Each element must have equal probability of being chosen
 *
 * @author Yashraj R. Sontakke
 */
public class RandomElementsInAArray {

    public Integer[] randomPick(Integer[] input, int m) {
        Integer[] subset = new Integer[m];
        for (int i = 0; i < m; i++) {
            subset[i] = input[i];
        }
        for (int i = m; i < input.length; i++) {
            int k = rand(0, i);
            if (k < m) {
                subset[k] = input[i];
            }
        }

        return subset;
    }

    public Integer[] randomPickRecursively(Integer[] input, int m, int i) {
        if (i + 1 == m) {
            Integer[] subset = new Integer[m];
            for (int j = 0; j < m; j++) {
                subset[j] = input[j];
            }
            return subset;
        } else if (i + 1 > m) {
            Integer[] subset = randomPickRecursively(input, m, i - 1);
            int k = rand(0, i);
            if (k < m) {
                subset[k] = input[i];
            }
            return subset;
        }
        return null;
    }

    public int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

    public static void main(String[] args) {
        RandomElementsInAArray randomElementsInAArray = new RandomElementsInAArray();
        Integer[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.asList(randomElementsInAArray.randomPick(input, 5)).toString());
        System.out.println(Arrays.asList(randomElementsInAArray.randomPickRecursively(input, 5, input.length - 1)).toString());
    }
}

