package practice.problems.others;

import java.util.LinkedList;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Note:
 You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0){
            return 0;
        }
        LinkedList<Integer> actionQueue = new LinkedList<>();
        LinkedList<Integer> stepQueue = new LinkedList<>();

        actionQueue.add(0);
        stepQueue.add(0);

        while (!actionQueue.isEmpty()) {
            int temp = actionQueue.poll();
            int step = stepQueue.poll();

            if(temp == amount) {
                return step;
            }
            for (int coin:coins) {
                if(temp+coin > amount) {
                    continue;
                } else {
                    if (!actionQueue.contains(temp+coin)) {
                        actionQueue.add(temp+coin);
                        stepQueue.add(step+1);
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args){
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(c.coinChange(new int[]{2}, 3));
    }
}
