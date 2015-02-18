package practice.problems.strings;

/**
 * Function to judge whether input string is number or not.
 *
 * @author Yashraj R. Sontakke
 */
public class StringToNumberCheck {

    /**
     * Checks if input string is a number
     *
     * @param input the input string to be evaluated
     * @return true when string is a number, false otherwise
     */
    public boolean isNumber(String input) {

        if (input == null || input.isEmpty()) {
            return false;
        }
        if (input.charAt(0) == '-' || input.charAt(0) == '+') {
            input = input.substring(1);
        }
        boolean decimalEncountered = false;
        for (Character character : input.toCharArray()) {
            if (character >= 48 && character <= 57) {
                continue;
            } else if (character == '.' && !decimalEncountered) {
                decimalEncountered = true;
            } else {
                return false;
            }
        }


        return true;
    }

    /**
     * Checks and prints result for input string passed
     *
     * @param input the input string to be evaluated
     */
    public void checkAndPrintNumberResult(String input) {
        if (isNumber(input)) {
            System.out.println(String.format("%s is a number", input));
        } else {
            System.out.println(String.format("%s is not a number", input));
        }
    }


    public static void main(String[] args) {
        StringToNumberCheck stringToNumberCheck = new StringToNumberCheck();
        stringToNumberCheck.checkAndPrintNumberResult("-3.3425");
        stringToNumberCheck.checkAndPrintNumberResult("80.0");
        stringToNumberCheck.checkAndPrintNumberResult("80.0.0");
        stringToNumberCheck.checkAndPrintNumberResult("-8+0.0");
        stringToNumberCheck.checkAndPrintNumberResult("80a90");

    }
}
