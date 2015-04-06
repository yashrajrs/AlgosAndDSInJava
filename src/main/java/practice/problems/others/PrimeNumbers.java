package practice.problems.others;

/**
 * Finds all the prime numbers .
 *
 * @author Yashraj R. Sontakke
 */
public class PrimeNumbers {

    /**
     * First approach O(nloglogn)
     * Sieve of Eratosthenes method
     */
    public void printPrimeNumbers(int n) {
        int upperBound = (int) Math.sqrt(n);
        boolean[] isComposite = new boolean[n + 1];
        for (int i = 2; i <= upperBound; i++) {
            if (!isComposite[i]) {
                for (int k = i * i; k <= n; k += i) {
                    isComposite[k] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                System.out.print(String.format("%d ", i));
            }
        }
    }

    /**
     * Second approach O(n2)
     */
    public void printPrimeNos(int n) {
        for (int i = 2; i <= n; i++) {
            int sqrtRoot = (int) Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 2; j <= sqrtRoot; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(String.format("%d ", i));
            }
        }
    }

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.printPrimeNumbers(120);
        System.out.println();
        primeNumbers.printPrimeNos(120);
    }
}
