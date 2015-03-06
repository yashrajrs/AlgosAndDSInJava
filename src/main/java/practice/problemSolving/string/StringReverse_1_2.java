package practice.problemSolving.string;

/**
 * Implement a function void reverse.
 *
 * @author Yashraj R. Sontakke
 */
public class StringReverse_1_2 {

    /**
     * First approach iterative
     */
    public void reverse(final String input) {
        String reversed = "";
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            System.out.println(" Input String is null / empty /blank");
            return;
        }
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed.concat(String.valueOf(input.charAt(i)));
        }

        System.out.println("STRING " + reversed);
    }

    public String reverseString(String input) {
        if (input.length() == 1) {
            return input;
        }
        return reverseString(input.substring(1)).concat(Character.toString(input.charAt(0)));
    }

    /**
     * Second approach recursive
     */
    public void reverseStringReverse(String input) {
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            System.out.println(" Input String is null / empty /blank");
            return;
        }
        System.out.println("STRING " + reverseString(input));
    }

    public static void main(String[] args) {

        StringReverse_1_2 s = new StringReverse_1_2();
        s.reverse("MY NAME IS YASHRAJ");
        s.reverse("ABCD");
        s.reverse(null);
        s.reverse("");
        s.reverse("  ");

        s.reverseStringReverse("MY NAME IS YASHRAJ");
        s.reverseStringReverse("ABCD");
        s.reverseStringReverse(null);
        s.reverseStringReverse("");
        s.reverseStringReverse("  ");
    }
}
