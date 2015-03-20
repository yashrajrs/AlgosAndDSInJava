package practice.problems;

/**
 * Convert decimal to octal.
 * 8 --> 10
 * 9 --> 11
 * 18 --> 22
 *
 * @author Yashraj R. Sontakke
 */
public class DecimalToOctal {

    public void convert(int input) {
        String output = "";
        while (input > 0) {
            output = input % 8 + output;
            input = input / 8;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        DecimalToOctal decimalToOctal = new DecimalToOctal();
        decimalToOctal.convert(8);
        decimalToOctal.convert(9);
        decimalToOctal.convert(18);

    }
}
