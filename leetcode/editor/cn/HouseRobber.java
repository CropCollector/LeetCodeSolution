package leetcode.editor.cn;

//Java：打家劫舍
public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        // TO TEST
        solution.rob(new int[]{1,2,3,1});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int dp1 = i - 1 < 0 ? 0 : dp[i - 1];
            int dp2 = i - 2 < 0 ? 0 : dp[i - 2];
            dp[i] = Math.max(dp1, dp2 + nums[i]);
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}