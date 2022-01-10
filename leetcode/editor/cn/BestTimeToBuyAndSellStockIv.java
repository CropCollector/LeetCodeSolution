package leetcode.editor.cn;

import java.util.Arrays;

//Java：买卖股票的最佳时机 IV
public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int len = prices.length;
            if (len == 0) {
                return 0;
            }
            int[] buy = new int[k + 1], sell = new int[k + 1];
            Arrays.fill(buy, -prices[0]);
            for (int i = 1; i < len; i++) {
                for (int j = 1; j <= k; j++) {
                    buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                    sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                }
            }
            return sell[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}