package leetcode.editor.cn;

//Java：买卖股票的最佳时机 II
public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int prev = prices[0], ans = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prev) {
                ans += prices[i] - prev;
            }
            prev = prices[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}