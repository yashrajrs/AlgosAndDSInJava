package practice.problems;

/**
 * Convert octal to decimal.
 * 10 --> 8
 * 11 --> 9
 * 22 -->18
 *
 * @author Yashraj R. Sontakke
 */
public class OctalToDecimal {

    public void convert(String input) {
        int output = 0;
        for (int i = 0; i < input.length(); i++) {
            output = 8 * output + input.charAt(i) - 48;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        OctalToDecimal octalToDecimal = new OctalToDecimal();
        octalToDecimal.convert("11");
    }
}
