package practice.otherProblems;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * @author Yashraj R. Sontakke
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        if(s.length() < 2){
            return true;
        }
        s = s.toLowerCase();
        int i =0;
        int j = s.length()-1;
        while(i < j){
            if(!isAlphaNumeric(s.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char a){
        if (a >= 'a' && a <= 'z'){
            return true;
        }
        return a>='0' && a<= '9';
    }

    public static void main(String[] args){
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(v.isPalindrome("race a car"));
        System.out.println(v.isPalindrome("A man, a p1la3n, a can3al: 1Panama"));
        System.out.println(v.isPalindrome("A man, a p1la3n, a canal: 1Panama"));
    }
}
