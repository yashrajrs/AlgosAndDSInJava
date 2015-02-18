package practice.problems.strings;

/**
 * Converts a string "998989" to 998989.
 *
 * @author Yashraj R. Sontakke
 */
public class ConvertStringToInteger {

    /**
     * Converts string to integer value
     *
     * @param input the input string to be converted
     * @throws IllegalStateException when the input string contains value other than 0-9.
     */
    public void convert(String input) {
        Integer value = 0;
        for (int i = 0; i < input.length(); i++) {

            Integer integer = getInteger(input.charAt(i));
            if (integer == -1) {
                throw new IllegalStateException("Input string contains value other than 0-9");
            }
            value = value * 10 + integer;
        }

        System.out.println("Converted number " + value);
    }

    /**
     * Retrieves integer value for the character passed
     *
     * @param input the input character
     * @return the integer value of the character, -1 for non 0-9 characters.
     */
    public Integer getInteger(char input) {
        switch (input) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        ConvertStringToInteger c = new ConvertStringToInteger();
        c.convert("998989");
        c.convert("998989abcd");
    }
}
