package leetcode.editor.cn;

//Java：买卖股票的最佳时机 III
public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
             /**
              * buy1[i] 表示第i天后进行一次购买的最大利润 初始为-prices[0]
              * sell1[i] 表示第i天后已进行一次卖出的最大利润 初始为0（进行一次买入后立刻卖出）
              * buy2[i] 表示第i天后进行两次购买的最大利润 初始为-prices[0]
              * sell2[i] 表示第i天后已进行两次卖出的最大利润 初始为0（进行两次买入卖出）
              */
            /*int[] buy1 = new int[len], sell1 = new int[len], buy2 = new int[len], sell2 = new int[len];
            buy1[0] = buy2[0] = -prices[0];
            for (int i = 1; i < len; i++) {
                buy1[i] = Math.max(buy1[i - 1], -prices[i]);
                sell1[i] = Math.max(sell1[i - 1], buy1[i - 1] + prices[i]);
                buy2[i] = Math.max(buy2[i - 1], sell1[i - 1] - prices[i]);
                sell2[i] = Math.max(sell2[i - 1], buy2[i - 1] + prices[i]);
            }
            return sell2[len - 1];*/

            // 优化
            int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i < len; i++) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}