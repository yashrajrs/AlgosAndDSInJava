package practice.problems.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement fibonacci numbers
 *
 * @author Yashraj R. Sontakke
 */
public class Fibonacci {

    public void fibonacciIterative(int n) {
        int prev = 0, current = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(prev + " ");
            current = current + prev;
            prev = current - prev;
        }
        System.out.println();

    }

    private void get(int a, int b){

        List<Integer> result = new ArrayList<Integer>();
        while(a>0){
            result.add(a);
            a = a-b;
            b = a+b;
            a = b-a;
            b = b-a;
        }
        result.add(0);
        System.out.println(result.toString());
    }

    /**
     *
     * @param n
     * @return
     */
    public int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public void fibo(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }



    public void mf2(int a, int b, int x, int y){

        while(a!=x && b!=y){

            if(a>x){
                a--;
            }else{
                a++;
            }
            if(b>y){
                b--;
            }else{
                b++;
            }
        }
        System.out.println("a" + a);
        System.out.println("x" + x);
        System.out.println("b" + b);
        System.out.println("y" + y);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
//        fibonacci.fibonacciIterative(5);
//        fibonacci.fibo(5);
//
//        fibonacci.get(80,50);
//        fibonacci.get(10,0);
//        fibonacci.get(0,0);

        fibonacci.mf2(2,5,10,7);


    }
}
