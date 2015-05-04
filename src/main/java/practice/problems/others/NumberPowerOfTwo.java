package practice.problems.others;

/**
 * Write a method that returns true if the given number is power of two.
 *
 * @author Yashraj R. Sontakke
 */
public class NumberPowerOfTwo {


    public boolean check(int input){
        if (input ==0 || input == 1){
            return false;
        }
        while(input > 1){
            if (input%2 != 0){
                return false;
            }
            input/=2;
        }
        return true;
    }


    public static void main(String[] args){
        NumberPowerOfTwo n = new NumberPowerOfTwo();
        System.out.println(n.check(4));
        System.out.println(n.check(10));
        System.out.println(n.check(14));
        System.out.println(n.check(8));
        System.out.println(n.check(16));
        System.out.println(n.check(20));
    }
}
