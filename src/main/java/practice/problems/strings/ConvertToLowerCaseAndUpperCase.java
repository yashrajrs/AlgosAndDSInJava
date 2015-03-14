package practice.problems.strings;

/**
 * Convert a string to lower case and upper case.
 *
 * @author Yashraj R. Sontakke
 */
public class ConvertToLowerCaseAndUpperCase {

    public void convertToLowerCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character character = chars[i];
            if (character.hashCode() >= 65 && character.hashCode() <= 90) {

                chars[i] = (char) (character.hashCode() + 32);
            }
        }

        System.out.println(new String(chars));
    }

    public void convertToUpperCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character character = chars[i];
            if (character.hashCode() >= 97 && character.hashCode() <= 122) {

                chars[i] = (char) (character.hashCode() - 32);
            }
        }

        System.out.println(new String(chars));
    }

    public static void main(String[] args) {
        ConvertToLowerCaseAndUpperCase convert = new ConvertToLowerCaseAndUpperCase();
        convert.convertToLowerCase("ABcd45eF");
        convert.convertToUpperCase("ABcd45eF");
    }
}
