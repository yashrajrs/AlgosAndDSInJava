package practice.problems;

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

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacciIterative(5);
        fibonacci.fibo(5);
    }
}
