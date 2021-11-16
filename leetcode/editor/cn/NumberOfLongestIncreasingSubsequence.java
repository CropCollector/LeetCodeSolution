package leetcode.editor.cn;

//Java：最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLen = 0, ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = count[i];
            } else if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}