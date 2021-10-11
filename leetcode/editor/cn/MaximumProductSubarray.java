package leetcode.editor.cn;

//Java：乘积最大子数组
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int[] maxDP = new int[nums.length];
            int[] minDP = new int[nums.length];
            int ans = maxDP[0] = minDP[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(minDP[i - 1] * nums[i], nums[i]));
                minDP[i] = Math.min(minDP[i - 1] * nums[i], Math.min(maxDP[i - 1] * nums[i], nums[i]));
                ans = Math.max(ans, maxDP[i]);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}