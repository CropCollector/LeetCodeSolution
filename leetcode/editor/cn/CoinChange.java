package leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // TO TEST
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    count = Math.min(count, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}