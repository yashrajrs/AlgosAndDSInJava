package practice.problems.others;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/22/15
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class BitsOfStringAddition {

    public void add(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        String c = "";
        int carry = 0;
        while (i >= 0 && j >= 0) {
            Number number = getNumber(a.charAt(i), b.charAt(i), carry);
            c = String.format("%d%s", number.getValue(), c);
            carry = number.getCarry();
            i--;
            j--;
        }

        while (i >= 0) {
            Number number = getNumber(a.charAt(i), '0', carry);
            c = String.format("%d%s", number.getValue(), c);
            carry = number.getCarry();
            i--;
        }

        while (j >= 0) {
            Number number = getNumber(b.charAt(j), '0', carry);
            c = String.format("%d%s", number.getValue(), c);
            carry = number.getCarry();
            j--;
        }
        if (carry > 0) {
            c = String.format("%d%s", carry, c);
        }
        System.out.println(c);
    }

    public Number getNumber(char a, char b, int carry) {
        int input1 = a == '1' ? 1 : 0;
        int input2 = b == '1' ? 1 : 0;

        int output = input1 + input2 + carry;
        if (output == 0) {
            return new Number(0, 0);
        } else if (output == 1) {
            return new Number(1, 0);
        } else if (output == 2) {
            return new Number(0, 1);
        } else {
            return new Number(1, 1);
        }
    }

    public static void main(String[] args) {
        BitsOfStringAddition bitsOfStringAddition = new BitsOfStringAddition();
        bitsOfStringAddition.add("100", "010");
        bitsOfStringAddition.add("100", "100");
        bitsOfStringAddition.add("100", "011");
        bitsOfStringAddition.add("101", "011");
        bitsOfStringAddition.add("111", "111");
    }

    public class Number {
        public int value;
        public int carry;

        public int getValue() {
            return value;
        }

        public int getCarry() {
            return carry;
        }

        public Number(int value, int carry) {
            this.value = value;
            this.carry = carry;
        }
    }
}
