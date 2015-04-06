package practice.problems.others;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/31/15
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class PowFunction {

    public double pow(double a, int b){
        if (b==0){
            return a==0?Integer.MIN_VALUE:1;
        }
        if (b==1){
            return 1;
        }
        boolean negativePower = false;
        if(b<0){
            negativePower = true;
        }

        double result = powHelper(a,Math.abs(b));
        if (negativePower){
            return 1/result;
        }
        return result;
    }

    public double powHelper(double a, int b){
        if (b==1){
            return a;
        }
        if ((b&1) ==1){
            return a *powHelper(a,b-1);
        }
        double result = powHelper(a,b/2);
        return result*result;
    }


    public void getPow(double a, int b){
        if (b==0){
            if(a==0){
                System.out.println(Integer.MIN_VALUE);
            }else {
                System.out.println(1);
            }
            return;
        }
        boolean negative = b<0 ? true:false;
        b = Math.abs(b);
        double value = 1;
        for (int i=0;i<b;i++){
            value *=a;
        }
        if (negative){
            value = 1/value;
        }
        System.out.println(value);
    }

    public static void main(String[] args){
        PowFunction powFunction = new PowFunction();
        System.out.println(powFunction.pow(2,-3));
//        System.out.println(powFunction.pow(2,4));
        powFunction.getPow(2,-3);
    }
}
