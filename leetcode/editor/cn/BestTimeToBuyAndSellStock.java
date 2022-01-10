package leetcode.editor.cn;

//Java：买卖股票的最佳时机
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int[] high = new int[len];
            int h = prices[len - 1];
            for (int i = len - 1; i >= 0; i--) {
                h = Math.max(h, prices[i]);
                high[i] = h;
            }

            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans = Math.max(ans, high[i] - prices[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}