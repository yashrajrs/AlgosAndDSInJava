package practice.problems.strings;

import java.util.ArrayList;

/**
 * Find minimum distance between two words (order preserved) in a big string.
 * For e.g 1. "hello how are you" - distance between "hello" and "you" is 3.
 * e.g 2. "hello how are hello you" - distance is 1
 * e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved.
 * e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 *
 * @author Yashraj R. Sontakke
 */
public class MinimumDistanceBetweenTwoWords {

    /**
     * First approach Time Complexity O(n)
     */
    public Integer minimumDistance1(String input, String firstWord, String secondWord) {
        String[] split = input.toLowerCase().split(" ");
        int firstWordLocation = -1;
        int secondWordLocation = -1;
        int minimumDistance = Integer.MAX_VALUE;
        int count = 0;
        for (String string : split) {
            if (string.equals(firstWord)) {
                firstWordLocation = count;
            }
            if (string.equals(secondWord)) {
                secondWordLocation = count;
            }
            if (firstWordLocation != -1 && secondWordLocation != -1) {

                if (minimumDistance > Math.abs(secondWordLocation - firstWordLocation)) {
                    minimumDistance = secondWordLocation - firstWordLocation;
                }
            }
            count++;

        }

        if (firstWordLocation == -1 || secondWordLocation == -1 || minimumDistance < 0) {
            return -1;
        }
        return minimumDistance;
    }

    /**
     * Second approach Time Complexity O(n2)
     */
    public Integer minimumDistance(String input, String firstWord, String secondWord) {
        String[] split = input.split(" ");
        ArrayList<Integer> firstWordLocation = new ArrayList<Integer>();
        ArrayList<Integer> secondWordLocation = new ArrayList<Integer>();

        int count = 0;
        for (String string : split) {
            if (string.equals(firstWord)) {
                firstWordLocation.add(count);
            } else if (string.equals(secondWord)) {
                secondWordLocation.add(count);
            }
            count++;
        }
        if (firstWordLocation.isEmpty() || secondWordLocation.isEmpty()) {
            return -1;
        }
        Integer minimumDistance = Integer.MAX_VALUE;
        for (Integer location1 : secondWordLocation) {
            for (Integer location2 : firstWordLocation) {
                if (location2 < location1 && location1 - location2 < minimumDistance) {
                    minimumDistance = location1 - location2;
                }
            }
        }
        if (minimumDistance < input.length()) {
            return minimumDistance;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenTwoWords minimumDistanceBetweenTwoWords = new MinimumDistanceBetweenTwoWords();
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance("hello how are you", "hello", "you"));
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance("hello how are hello you", "hello", "you"));
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance("you are hello", "hello", "you"));
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance("hello how are hello", "hello", "you"));

        System.out.println("########------------#############");
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance1("hello how are you", "hello", "you"));
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance1("hello how are hello you", "hello", "you"));
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance1("you are hello", "hello", "you"));
        System.out.println(minimumDistanceBetweenTwoWords.minimumDistance1("hello how are hello", "hello", "you"));
    }
}
