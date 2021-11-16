package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长递增子序列
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // TO TEST
        solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}