package leetcode.editor.cn;

//Java：剪绳子
public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        // dp[i] 表示长度为i的绳子可以得到的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}