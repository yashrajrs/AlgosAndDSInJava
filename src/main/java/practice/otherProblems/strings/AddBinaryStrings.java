package practice.otherProblems.strings;

/**
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */
public class AddBinaryStrings {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() -1;
        int j = b.length() -1;
        int carry = 0;

        while (i>=0 || j>=0) {
            int sum = 0;
            if (i >= 0 && a.charAt(i) == '1') {
                sum++;
            }

            if (j >= 0 && b.charAt(j) == '1') {
                sum++;
            }
            sum+= carry;

            if (sum>=2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, (char) ((sum%2) + '0'));
            i--;
            j--;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static void main(String[] args){
        AddBinaryStrings d = new AddBinaryStrings();
        System.out.println(d.addBinary("11", "1"));
        System.out.println(d.addBinary("1010", "1011"));
    }
}
