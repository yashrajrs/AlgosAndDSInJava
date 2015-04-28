package practice.otherProblems;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 *Design an algorithm to find the maximum profit.
 *You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * @author Yashraj R. Sontakke
 */
public class BestTimeToSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i =1; i< prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String[] args){
        BestTimeToSellStock2 b = new BestTimeToSellStock2();

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(b.maxProfit(input));
    }
}
