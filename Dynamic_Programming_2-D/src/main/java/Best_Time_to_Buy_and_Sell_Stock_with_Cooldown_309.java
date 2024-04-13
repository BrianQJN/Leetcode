/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-12
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    /**
     * @param prices an array prices where prices[i] is the price of a given stock on the ith day
     * @return int - the maximum profit you can achieve.
     * @implSpec You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
     * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
     * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
     * @author Brian Qu
     * @since 2024-04-12 15:15
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // initialize the state table
        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        // update the state tables
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i-1], rest[i-1] - prices[i]);
            sold[i] = hold[i-1] + prices[i];
            rest[i] = Math.max(rest[i-1], sold[i-1]);
        }

        // return the result
        return Math.max(sold[n-1], rest[n-1]);
    }
}
