package practice.careercup;

/**
 * How to calculate sum of all numbers in a string. Example 11aa22bb33dd44 =110
 Note: Should not use Regex and replace
 */
public class StringSum {

    public int value(String input) {
        int result = 0;

        int i=0;
        int curVal = 0;
        for (char c: input.toCharArray()) {
            if (c >='0' && c<='9') {
                curVal = curVal*10 + c-48;
            } else {
                result += curVal;
                curVal = 0;
            }
            i++;
        }
        result += curVal;
        return result;
    }

    public static void main(String[] args) {
        StringSum s= new StringSum();
        String input = "11aa22bb33dd44";
        System.out.println(s.value(input));
    }
}
