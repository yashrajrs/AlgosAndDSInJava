package practice.problemSolving.recursion;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps,
 * or 3 steps at a time. Implement a method to count how many possible ways the
 * child can run up the stairs.
 *
 * @author Yashraj R. Sontakke
 */
public class WaysToSolve_9_1 {

    int[] map = new int[100];

    public Integer waysToSolve(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > 0) {
            return map[n];
        } else {
            map[n] = waysToSolve(n - 1) + waysToSolve(n - 2) + waysToSolve(n - 3);
            return map[n];
        }
    }

    public static void main(String[] args) {
        WaysToSolve_9_1 waysToSolve = new WaysToSolve_9_1();
        int n = 4;
        if (n == 0) {
            System.out.println("0 ways");
        } else {
            System.out.println(waysToSolve.waysToSolve(n) + " ways");
        }
    }
}
