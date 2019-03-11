package practice.otherProblems.string;

import java.util.*;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



 Example 1:

 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 Example 2:

 Input: amount = 3, coins = [2]
 Output: 0
 Explanation: the amount of 3 cannot be made up just with coins of 2.
 Example 3:

 Input: amount = 10, coins = [10]
 Output: 1


 Note:

 You can assume that

 0 <= amount <= 5000
 1 <= coin <= 5000
 the number of coins is less than 500
 the answer is guaranteed to fit into signed 32-bit integer
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        Set<List<Integer>> result = new HashSet<>();
        change(amount, coins, result, new ArrayList<Integer>(), 0);
        System.out.println(result);
        return result.size();
    }

    public void change(int amount, int[] coins, Set<List<Integer>> result, List<Integer> temp, int currentVal) {
        if(amount == currentVal) {

            Integer[] arr = new Integer[temp.size()];
            for (int i=0;i<temp.size();i++) {
                arr[i] = temp.get(i);
            }

            Arrays.sort(arr);
            List<Integer> temp1 = Arrays.asList(arr);
            if(!result.contains(temp1)) {
                result.add(new ArrayList<>(temp1));
            }
            return;
        }
        if(currentVal > amount) {
            return;
        }
        for(int i=coins.length-1; i>=0;i--) {
            int coin = coins[i];
            if(currentVal + coin <= amount) {
                temp.add(coin);
                change(amount,coins, result, temp, currentVal+ coin);
                temp.remove(temp.size()-1);
            }
        }
    }

    /*
             amount(j) 0 1 2 3 4 5
       coin(i)
        0              1 0 0 0 0 0
        1              1 1 1 1 1 1
        2              1 1 2 2 3 3
        5              1 1 2 2 3 4
       */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins) {
            for(int j=coin;j<=amount;j++) {
                dp[j] += dp[j-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        CoinChange2 c = new CoinChange2();
        System.out.println(c.change(5, new int[]{1, 2, 5}));
        System.out.println(c.change2(5, new int[]{1, 2, 5}));
    }
}
