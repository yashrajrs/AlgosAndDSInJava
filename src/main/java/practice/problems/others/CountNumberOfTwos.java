package practice.problems.others;

/**
 * Write a method to count the number of 2s that appear in all the numbers
 * between 0 and n (inclusive).
 * EXAMPLE
 * Input: 25
 * Output: 9 (2,12,20,21,22,23, 24 and 25. Note that 22 counts for two 2s.)
 *
 * @author Yashraj R. Sontakke
 */
public class CountNumberOfTwos {

    public int numbersInRange(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count += numberOf2s(i);
        }
        return count;
    }

    private int numberOf2s(int i) {
        int count = 0;
        while (i > 0) {
            if (i % 10 == 2) {
                count += 1;
            }
            i = i / 10;
        }

        return count;
    }

    public int count2sinRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int i = 0; i < len; i++) {
            count += count2sinRangeAtDigit(number, i);
        }
        return count;
    }

    private int count2sinRangeAtDigit(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowOf10;
        int roundUp = roundDown + nextPowOf10;

        int digit = (number / powerOf10) % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }

    public static void main(String[] args) {
        CountNumberOfTwos countNumberOfTwos = new CountNumberOfTwos();
        System.out.println(countNumberOfTwos.numbersInRange(25));
        System.out.println(countNumberOfTwos.count2sinRange(125));
    }
}
