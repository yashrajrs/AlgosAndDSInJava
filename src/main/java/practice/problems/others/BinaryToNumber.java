package practice.problems.others;

/**
 * Convert binary to decimal.
 * 0101 --> 5
 *
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryToNumber {

    public void convert(int[] binary){
        Double decimal = 0.0;
        for (int i=binary.length-1;i>=0;i--){
            if (binary[i] ==1){
                decimal = decimal + Math.pow(2,binary.length-1-i);
            }
        }
        System.out.println(decimal.intValue());
    }

    public static void main(String[] args){
        BinaryToNumber binaryToNumber = new BinaryToNumber();
        int[] input = {0,1,0,1};
        binaryToNumber.convert(input);

        int[] input1 = {1,0,0,1};
        binaryToNumber.convert(input1);

        int[] input2 = {0,1,0,0};
        binaryToNumber.convert(input2);

        int[] input3 = {0,0,1,1};
        binaryToNumber.convert(input3);

        int[] input4 = {0,1,1,1};
        binaryToNumber.convert(input4);

        int[] input5 = {1,0,1,1};
        binaryToNumber.convert(input5);

    }
}
