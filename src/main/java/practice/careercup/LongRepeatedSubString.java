package practice.careercup;

/**
 * Find out the longest repeated common sub-string(overlapped) in a string.
 For example:- mystr = banana # The "ana" is the common overlapped sub-string is been used 2 times.


 */
public class LongRepeatedSubString {

    public String longSubString(String input) {
        String longestString = "";
        for (int i=0; i<input.length(); i++) {
            for (int j=i+1;j<input.length();j++) {
                String sub = input.substring(i, j);
                String remainingString = input.substring(j-1);
                if (remainingString.contains(sub)) {
                    if (sub.length() > longestString.length()) {
                        longestString = sub;
                    }
                }
            }
        }
        return longestString;
    }

    public static void main(String[] args) {
        LongRepeatedSubString l = new LongRepeatedSubString();
        String input = "banana";
        System.out.println(l.longSubString(input));
    }
}
