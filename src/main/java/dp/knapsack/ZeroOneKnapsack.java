package dp.knapsack;

public class ZeroOneKnapsack {

    /**
     * 0/1 Knapsack Problem
     * <br/>
     * Assumptions:
     * <ol>
     *     <li>weights.length = values.length > 0;</li>
     *     <li>cap > 0</li>
     * </ol>
     *
     * @param weights The array of weights of the items
     * @param values  The array of values of the items
     * @param cap     The maximum weight the knapsack is capable of
     * @return The maximum value of the items the knapsack can contain given the capacity
     */
    public static int knapsack(int[] weights, int[] values, int cap) {
        // dp[i][w]: solution (maximum value) for the first i items with the remaining capacity w
        // Goal: find dp[n][cap]
        int[][] dp = new int[weights.length + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // Note: the index of the ith item is i - 1 (weights[i - 1])
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - weights[i - 1]] + values[i - 1]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[weights.length][cap];
    }

    public static int knapsack_1D(int[] weights, int[] values, int cap) {
        int[] dp = new int[cap + 1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = cap; j >= 1; j--) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }

        return dp[cap];
    }

}
