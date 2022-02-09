package leetcode.editor.cn;

//Java：长度最小的子数组
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // TO TEST
        System.out.println(solution.minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int len = nums.length, l = 0, sum = 0, ans = Integer.MAX_VALUE;
            for (int r = 0; r < len; r++) {
                sum += nums[r];
                if (sum >= target) {
                    while (l < r && sum - nums[l] >= target) {
                        sum -= nums[l ++];
                    }
                    ans = Math.min(r - l + 1, ans);
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}