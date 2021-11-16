package leetcode.editor.cn;

//Java：完全平方数
public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(1 + dp[i - j * j], min);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}