package practice.problems.strings;

/**
 * /**
 * Return the smallest character that is strictly larger than the search character,
 * If no such character exists, return the smallest character in the array
 * ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'
 * ['c', 'f', 'j', 'p', 'v'], 'c' => 'f'
 * ['c', 'f', 'j', 'p', 'v'], 'k' => 'p'
 * ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case
 * ['c', 'f', 'k'], 'f' => 'k'
 * ['c', 'f', 'k'], 'c' => 'f'
 * ['c', 'f', 'k'], 'd' => 'f'
 *
 * @author Yashraj R. Sontakke
 */
public class SmallestNextCharacter {

    /**
     * First approach int array is sorted
     */
    public Character smallestCharacter(Character[] sorted, char search) {
        for (char c : sorted) {
            if (c > search) {
                return c;
            }
        }
        return sorted[0];
    }

    /**
     * Second approach - Input array is not sorted
     */
    public Character getSmallestNextCharacter(Character[] input, Character search) {
        Integer searchHashCode = search.hashCode();
        Integer minNextHashCode = null;
        Character minNext = null;
        for (Character c : input) {
            if (c.hashCode() > searchHashCode && (minNext == null || c.hashCode() < minNextHashCode)) {
                minNext = c;
                minNextHashCode = c.hashCode();
            }
        }
        if (minNextHashCode != null) {
            return minNext;
        } else {
            return getMinimum(input);
        }
    }

    public Character getMinimum(Character[] input) {
        Integer minimumHashCode = input[0].hashCode();
        Character minimum = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i].hashCode() < minimumHashCode) {
                minimumHashCode = input[i].hashCode();
                minimum = input[i];
            }
        }
        return minimum;
    }

    public static void main(String[] args) {

        SmallestNextCharacter smallestNextCharacter = new SmallestNextCharacter();
        Character[] input1 = {'c', 'f', 'j', 'p', 'v'};
        Character[] input2 = {'c', 'f', 'j', 'p', 'v'};
        Character[] input3 = {'c', 'f', 'j', 'p', 'v'};
        Character[] input4 = {'c', 'f', 'j', 'p', 'v'};
        Character[] input5 = {'c', 'f', 'k'};
        Character[] input6 = {'c', 'f', 'k'};
        Character[] input7 = {'c', 'f', 'k'};
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input1, 'a'));
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input2, 'c'));
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input3, 'k'));
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input4, 'z'));
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input5, 'f'));
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input6, 'c'));
        System.out.println(smallestNextCharacter.getSmallestNextCharacter(input7, 'd'));

        System.out.println("########------------#############");
        System.out.println(smallestNextCharacter.smallestCharacter(input1, 'a'));
        System.out.println(smallestNextCharacter.smallestCharacter(input2, 'c'));
        System.out.println(smallestNextCharacter.smallestCharacter(input3, 'k'));
        System.out.println(smallestNextCharacter.smallestCharacter(input4, 'z'));
        System.out.println(smallestNextCharacter.smallestCharacter(input5, 'f'));
        System.out.println(smallestNextCharacter.smallestCharacter(input6, 'c'));
        System.out.println(smallestNextCharacter.smallestCharacter(input7, 'd'));
    }
}
