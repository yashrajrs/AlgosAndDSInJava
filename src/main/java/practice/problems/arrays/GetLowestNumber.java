package practice.problems.arrays;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Where the number parameter is a string that contains a number (e.g. “4205123”),
 * and the n parameter represents the number of characters to remove from the string
 * Example if number is “4205123” and n is 4, output is "012".
 * if number is “216504” and n is 3, output is "104".
 *
 * @author Yashraj R. Sontakke
 */
public class GetLowestNumber {
    public Set<String> lowestNumbers = Sets.newHashSet();

    public void generateLowest(ArrayList<Character> input, ArrayList<Character> currentNumber, int minimumLength) {
        if (currentNumber.size() >= minimumLength) {
            lowestNumbers.add(getNumber(currentNumber));

        }

        if (input.size() == minimumLength || input.isEmpty()) {
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Character> newInput = new ArrayList<Character>(input.subList(i + 1, input.size()));
            ArrayList<Character> newCurrentNumber = new ArrayList<Character>(currentNumber);
            newCurrentNumber.add(input.get(i));
            generateLowest(newInput, currentNumber, minimumLength);
            generateLowest(newInput, newCurrentNumber, minimumLength);
        }

    }

    public String getNumber(ArrayList<Character> input) {
        StringBuilder builder = new StringBuilder(input.size());
        for (Character c : input) {
            builder.append(c);
        }
        return builder.toString();
    }


    public void getLowest(ArrayList<Character> input, int n) {
        generateLowest(input, new ArrayList<Character>(), input.size() - n);

        if (lowestNumbers.isEmpty()) {
            return;
        }
        String lowestNumber = String.valueOf(Integer.MAX_VALUE);
        for (String number : lowestNumbers) {
            if (Integer.parseInt(number) < Integer.parseInt(lowestNumber)) {
                lowestNumber = number;
            }
        }

        System.out.println(lowestNumber);
    }

    public static void main(String[] args) {
        GetLowestNumber GetLowestNumber = new GetLowestNumber();
        ArrayList<Character> input = new ArrayList<Character>(Arrays.asList('4', '2', '0', '5', '1', '2', '3'));
        GetLowestNumber.getLowest(input, 4);

        GetLowestNumber.lowestNumbers = new HashSet<String>();
        ArrayList<Character> input1 = new ArrayList<Character>(Arrays.asList('2', '1', '6', '5', '0', '4'));
        GetLowestNumber.getLowest(input1, 3);
    }
}
