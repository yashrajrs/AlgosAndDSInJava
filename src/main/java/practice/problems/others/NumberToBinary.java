package practice.problems.others;

/**
 * Convert a number to binary.
 * 5 --> 0101
 * 9 --> 1001
 *
 * @author Yashraj R. Sontakke
 */
public class NumberToBinary {

    public void convert(int input) {
        int[] binary = new int[4];

        int i = binary.length - 1;
        while (input > 0) {
            binary[i] = input % 2;
            input = input / 2;
            i--;
        }

        for (int k = 0; k < binary.length; k++) {
            System.out.print(binary[k]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NumberToBinary numberToBinary = new NumberToBinary();

        numberToBinary.convert(5);
        numberToBinary.convert(9);
        numberToBinary.convert(4);
        numberToBinary.convert(3);
        numberToBinary.convert(7);
        numberToBinary.convert(11);
    }
}
