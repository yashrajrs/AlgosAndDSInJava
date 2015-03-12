package practice.problems.strings;

/**
 * Remove adjacent duplicates.
 * EXAMPLE "aabzzzbyzr" ---> "yzr"
 *
 * @author Yashraj R. Sontakke
 */
public class RemoveAdjacentDuplicates {

    public void removeDuplicates(String input) {
        if (input.length() == 1) {
            return;
        }
        int count = 0;
        char currentCharacter;
        String newString = "";
        boolean duplicatedEncountered = true;
        while (true) {
            if (input.length() <= 1) {
                System.out.println(input);
                return;
            }
            duplicatedEncountered = false;
            currentCharacter = input.charAt(0);

            for (int i = 1; i < input.length(); i++) {
                if (currentCharacter == input.charAt(i)) {
                    count++;
                } else {
                    if (count > 0) {
                        count = 0;
                        duplicatedEncountered = true;
                    } else {
                        newString = newString.concat(Character.toString(currentCharacter));
                    }
                    currentCharacter = input.charAt(i);
                }
            }

            if (count > 0) {
                count = 0;
            } else {
                newString = newString.concat(Character.toString(currentCharacter));
            }

            if (!duplicatedEncountered) {
                System.out.println(newString);
                break;
            }
            input = newString;
            newString = "";
        }
    }

    public static void main(String[] args) {
        RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();
        removeAdjacentDuplicates.removeDuplicates("aabzzzbyzr");
    }
}
