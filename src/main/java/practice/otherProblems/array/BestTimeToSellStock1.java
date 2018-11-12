package practice.otherProblems.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.


 * @author Yashraj R. Sontakke
 */
public class BestTimeToSellStock1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int lowest = Integer.MAX_VALUE;
        int profit = 0;

        for(int curPrice : prices){
            lowest = Math.min(lowest, curPrice);
            profit = Math.max(profit, curPrice - lowest);
        }
        return profit;
    }


    public static void main(String[] args){
        BestTimeToSellStock1 b = new BestTimeToSellStock1();

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(b.maxProfit(input));

        int[] input2 = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(input2));

        int[] input3 = {7,6,4,3,1};
        System.out.println(b.maxProfit(input3));
    }
}
