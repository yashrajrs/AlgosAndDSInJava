package practice.otherProblems;

/**
 * Implement pow(x, n).
 *
 * @author Yashraj R. Sontakke
 */
public class PowFunction {

    public double myPow(double x, int n) {
        if(n < 0){
            return 1/pow(x, -n);
        }
        return pow(x, n);
    }

    private double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        double v = pow(x, n/2);
        if(n%2 == 0){
            return v * v;
        }
        return v * v * x;
    }

    public static void main(String[] args){
        PowFunction powFunction = new PowFunction();
        System.out.println(powFunction.myPow(2,-3));
        System.out.println(powFunction.myPow(2,4));
    }
}
