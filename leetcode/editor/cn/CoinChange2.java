package leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换 II
public class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        // TO TEST
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // dp[i] =
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(String.format("%s -- %s", coins[i], toString(dp)));
        }
        return dp[amount];
    }

    public String toString(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}