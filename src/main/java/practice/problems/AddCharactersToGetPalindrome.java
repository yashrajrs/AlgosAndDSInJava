package practice.problems;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Find minimum number of characters needed to be added to the end of a string to make it palindrome.
 *
 * @author Yashraj R. Sontakke
 */
public class AddCharactersToGetPalindrome {

    public Set<String> palindromes = Sets.newHashSet();

    public void findPalindromes(String input, int maxLength) {
        if (isPalindrome(input)) {
            palindromes.add(input);
            return;
        }
        if (input.length() >= maxLength) {
            return;
        }

        for (Character c = 'a'; c <= 'z'; c++) {
            if (input.contains(Character.toString(c))) {
                String newString = new String(input);
                newString = newString.concat(Character.toString(c));
                findPalindromes(newString, maxLength);
            }
        }
    }


    public void getMinimumCharacters(String input) {
        palindromes = Sets.newHashSet();
        findPalindromes(input, 2 * input.length());

        String minimum = null;
        Integer minimumNumbers = Integer.MAX_VALUE;

        for (String palindrome : palindromes) {
            if (palindrome.length() < minimumNumbers) {
                minimumNumbers = palindrome.length();
                minimum = palindrome;
            }
        }
        System.out.println(String.format("Minimum palindrome %s with %d number of characters", minimum, minimumNumbers - input.length()));
    }

    public boolean isPalindrome(String input) {
        String reverse = new StringBuilder(input).reverse().toString();
        return input.equals(reverse);
    }


    public static void main(String[] args) {
        AddCharactersToGetPalindrome addCharactersToGetPalindrome = new AddCharactersToGetPalindrome();
        addCharactersToGetPalindrome.getMinimumCharacters("ab");
        addCharactersToGetPalindrome.getMinimumCharacters("aa");
        addCharactersToGetPalindrome.getMinimumCharacters("abcd");
        addCharactersToGetPalindrome.getMinimumCharacters("abcda");
        addCharactersToGetPalindrome.getMinimumCharacters("abcdad");
    }
}
