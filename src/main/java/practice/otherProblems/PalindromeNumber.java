package practice.otherProblems;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/4/15
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        int div = 1;
        while(x/div >= 10){
            div *=10;
        }
        while (x!=0){
            int left = x/div;
            int right = x%10;
            if (left!=right){
                return false;
            }
            x = (x%div)/10;
            div /=100;
        }
        return true;
    }

    public static void main(String[] args){
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(212));
        System.out.println(p.isPalindrome(213));
        System.out.println(p.isPalindrome(2112));
    }
}
