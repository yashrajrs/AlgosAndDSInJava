package practice.problems.others;

/**
 * Convert hexadecimal to decimal.
 * A --> 10
 * 14 --> 20
 * 1F --> 31
 *
 * @author Yashraj R. Sontakke
 */
public class HexadecimalToDecimal {

    String digits = "0123456789ABCDEF";

    public void convert(String input) {
        input = input.toUpperCase();
        int output = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int d = digits.indexOf(c);
            output = 16 * output + d;
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        HexadecimalToDecimal hexadecimalToDecimal = new HexadecimalToDecimal();
        hexadecimalToDecimal.convert("A");
        hexadecimalToDecimal.convert("14");
        hexadecimalToDecimal.convert("1f");
    }
}
