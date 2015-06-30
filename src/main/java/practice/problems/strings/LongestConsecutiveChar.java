package practice.problems.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * First they did ask to find pattern of this
 * <p/>
 * <p/>
 * 'this is a test sentence' => [t, h, i, s, i, s, a, t, e, s, t, s, e, n, t, e, n, c, e]
 * 'thiis iss a teest seentennce' => [i, s, e, e, n]
 * 'thiiis iss aa teeest seentennnce' => [i, e, n]
 * 'thiiiis iss a teeest seeentennncccce' => [i, c]
 * after i have to do body of function
 * <p/>
 * <p/>
 * getLongestConsecutiveChar
 *
 * @author Yashraj R. Sontakke
 */
public class LongestConsecutiveChar {


    public void getLongestConsecutiveChar(String input) {
        if (input.length() == 0) {
            System.out.println("[]");
            return;
        } else if (input.length() == 1) {
            if (input.charAt(0) != ' ') {
                System.out.println(String.format("[%c]", input.charAt(0)));
            }

            return;
        }
        final HashMap<Integer, ArrayList<Character>> consecutiveCharacters = new HashMap<Integer, ArrayList<Character>>();

        int count = 1;
        Character currentCharacter = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (currentCharacter != input.charAt(i)) {
                if (currentCharacter != ' ') {
                    addCharacterToMap(consecutiveCharacters, count, currentCharacter);
                }
                count = 1;
                currentCharacter = input.charAt(i);
            } else {
                count++;
            }
        }
        if (currentCharacter != ' ') {
            addCharacterToMap(consecutiveCharacters, count, currentCharacter);
        }

        final Integer max = Collections.max(consecutiveCharacters.keySet());

        System.out.println(consecutiveCharacters.get(max).toString());
    }

    private void addCharacterToMap(HashMap<Integer, ArrayList<Character>> consecutiveCharacters, int count, Character currentCharacter) {
        if (consecutiveCharacters.containsKey(count)) {
            final ArrayList<Character> characters = consecutiveCharacters.get(count);
            characters.add(currentCharacter);

        } else {
            ArrayList<Character> characters = new ArrayList<Character>();
            characters.add(currentCharacter);
            consecutiveCharacters.put(count, characters);
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveChar longestConsecutiveChar = new LongestConsecutiveChar();
        longestConsecutiveChar.getLongestConsecutiveChar("this is a test sentence");
        longestConsecutiveChar.getLongestConsecutiveChar("thiis iss a teest seentennce");
        longestConsecutiveChar.getLongestConsecutiveChar("thiiis iss aa teeest seentennnce");
        longestConsecutiveChar.getLongestConsecutiveChar("thiiiis iss a teeest seeentennncccce");

        longestConsecutiveChar.getLongestConsecutiveChar("this s");
    }
}
