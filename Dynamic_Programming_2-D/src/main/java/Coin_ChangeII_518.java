/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-04-13
 */
public class Coin_ChangeII_518 {
    /**
     * @param amount an integer representing a total amount of money
     * @param coins an integer array coins representing coins of different denominations
     * @return int -
     * @implSpec You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
     * You may assume that you have an infinite number of each kind of coin.
     * The answer is guaranteed to fit into a signed 32-bit integer.
     * @author Brian Qu
     * @since 2024-04-13 15:15
     */
    public int change(int amount, int[] coins) {
        // initialize the dp array
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
