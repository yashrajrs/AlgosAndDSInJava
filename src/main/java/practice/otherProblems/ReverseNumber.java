package practice.otherProblems;

/**
 * Reverse digits of an integer.

 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * @author Yashraj R. Sontakke
 */
public class ReverseNumber {
    public int reverse(int x) {
        if(x > -10 && x < 10){
            return x;
        }
        boolean negative = x<10 ? true : false;
        if(negative){
            x = Math.abs(x);
        }
         int y = 0;
        while(x>0){
            y = y*10 + x%10;
            x = x/10;
        }
        if (y>Integer.MAX_VALUE) {
            return 0;
        }
        if(negative){
            y = y * -1;
        }
        return y;
    }

    public static void main(String[] args){
        ReverseNumber r = new ReverseNumber();
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(-1));
        System.out.println(r.reverse(0));
        System.out.println(r.reverse(1));
        System.out.println(r.reverse(1534236469));
    }
}
