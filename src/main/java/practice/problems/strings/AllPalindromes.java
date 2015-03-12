package practice.problems.strings;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Find all palindromes in a given string. Single letters are also considered as palindromes.
 *
 * @author Yashraj R. Sontakke
 */
public class AllPalindromes {

    Set<String> palindromes = Sets.newHashSet();

    /**
     * First approach all possible palindromes.
     *
     * @param input
     * @param currentArray
     */
    public void getPalindromes(List<Character> input, List<Character> currentArray) {

        if (isPalindrome(currentArray)) {
            palindromes.add(currentArray.toString());
        }
        if (input.isEmpty()) {
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            List<Character> newInput = input.subList(i + 1, input.size());
            List<Character> newCurrentArray = new ArrayList<Character>(currentArray);
            newCurrentArray.add(input.get(i));
            getPalindromes(newInput, newCurrentArray);
        }
    }

    public boolean isPalindrome(List<Character> input) {
        if (input.size() < 1) {
            return false;
        }
        for (int i = 0; i < input.size() / 2; i++) {
            if (input.get(i) != input.get(input.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Second approach returns the contiguous palindromes
     */
    public void getContiguousPalindromes(List<Character> input) {
        Set<String> contiguousPalindromes = Sets.newHashSet();
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                List<Character> currentInput = input.subList(i, j + 1);
                if (isPalindrome(currentInput)) {
                    contiguousPalindromes.add(currentInput.toString());
                }
            }
        }
        System.out.println(contiguousPalindromes.toString());
    }


    public static void main(String[] args) {
        AllPalindromes allPalindromes = new AllPalindromes();
        List<Character> input = Arrays.asList('m', 'i', 's', 's', 'i', 's', 's', 'i', 'p', 'p', 'i');
        List<Character> currentArray = new ArrayList<Character>();
        allPalindromes.getPalindromes(input, currentArray);
        System.out.println(allPalindromes.palindromes.toString());

        System.out.println();
        allPalindromes.getContiguousPalindromes(input);

    }
}
