package practice.problems.others;

/**
 * Convert decimal to hexadecimal.
 * 10 --> A
 * 20 --> 14
 * 31 --> 1F
 *
 * @author Yashraj R. Sontakke
 */
public class DecimalToHexadecimal {

    char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public void convert(int input) {
        String output = "";
        int rem;
        while (input > 0) {
            rem = input % 16;
            output = hex[rem] + output;
            input = input / 16;
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        DecimalToHexadecimal decimalToHexadecimal = new DecimalToHexadecimal();
        decimalToHexadecimal.convert(10);
        decimalToHexadecimal.convert(20);
        decimalToHexadecimal.convert(31);
        decimalToHexadecimal.convert(47);
    }
}
