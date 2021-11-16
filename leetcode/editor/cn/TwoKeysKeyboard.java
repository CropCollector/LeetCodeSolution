package leetcode.editor.cn;

//Java：只有两个键的键盘
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new TwoKeysKeyboard().new Solution();
        // TO TEST
        System.out.println(solution.minSteps(2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}