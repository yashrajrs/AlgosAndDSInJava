package practice.otherProblems;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        for (int i=0;i<s.length()/2;i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                int j = s.length()-1-i;
                return (isPalindrome(s, i+1,j) || isPalindrome(s, i, j-1));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {

        for (int k=i;k<= (i+j)/2;k++) {
            if (s.charAt(k) != s.charAt(j-k+i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome2 v  =new ValidPalindrome2();
        System.out.println(v.validPalindrome("aba"));
//        System.out.println(v.validPalindrome("abca"));

//        System.out.println(v.validPalindrome("abcdfcba"));
        System.out.println(v.validPalindrome("abcddcbza"));
    }
}
