package practice.problems.others;

/**
 * Write code to sum 2 integer but u cant use a+b method,
 * you have to use either ++ or --. How you will handle negative numbers.
 *
 * @author Yashraj R. Sontakke
 */
public class TwoIntegerSum {

    public int add(int a, int b){
        while (a>0){
            a--;
            b++;
        }
        while (a<0){
            a++;
            b--;
        }
        return b;
    }

    public static void main(String[] args){
        TwoIntegerSum t = new TwoIntegerSum();
        System.out.println(t.add(2,5));
        System.out.println(t.add(-2,5));
    }
}
