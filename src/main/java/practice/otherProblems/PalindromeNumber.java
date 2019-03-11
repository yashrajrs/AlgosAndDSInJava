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

    public boolean isPalindrome1(int x){
        if (x < 0 || (x%10 == 0 && x != 0)) {
            return false;
        }
        int revNum = 0;
        while (x > revNum) {
            revNum = revNum * 10 + x %10;
            x /= 10;
        }
        return x == revNum || x == revNum/10;
    }

    public static void main(String[] args){
        PalindromeNumber p = new PalindromeNumber();
//        System.out.println(p.isPalindrome(212));
//        System.out.println(p.isPalindrome1(212));
//        System.out.println(p.isPalindrome(213));
//        System.out.println(p.isPalindrome1(213));
//        System.out.println(p.isPalindrome(2112));
//        System.out.println(p.isPalindrome1(2112));

        System.out.println(p.isPalindrome(1234321));
    }
}
