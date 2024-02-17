import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-02-12
 */
public class Coin_Change_322 {
    /**
     * @param coins coins of different denominations
     * @param amount an integer represents a total amount of money
     * @return int - the fewest number of coins to make up the amount
     * @implSpec You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     * @author Brian Qu
     * @since 2024-02-12 14:14
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
