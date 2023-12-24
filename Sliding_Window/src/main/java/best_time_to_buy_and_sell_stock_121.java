/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-24
 */
public class best_time_to_buy_and_sell_stock_121 {
    /**
     * @implSpec You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * @author Brian Qu
     * @param prices an array of prices of a stock
     * @return int - the max profit you can earn
     * @since 2023-12-24 16:50
     */
    public int maxProfit(int[] prices) {
        // initialize the sliding window and maxProfit
        int left = 0, right = 1;
        int maxProfit = 0;

        // move the window to find the maxProfit
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
