package leetcode.editor.cn;

//Java：目标和
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int ans = 0;

        private int[] nums;

        private int len;

        private int target;

        private int[] sums;

        public int findTargetSumWays(int[] nums, int target) {
            this.nums = nums;
            this.len = nums.length;
            this.target = target;
            this.sums = new int[len];

            sums[0] = nums[0];
            for (int i = 1; i < len; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }

            dfs(0, 0);
            return ans;
        }

        private void dfs(int i, int sum) {
            if (i == len) {
                if (sum == target) {
                    ans ++;
                }
                return;
            }

            int rest = sums[len - 1] - (i == 0 ? 0 : sums[i - 1]);
            if (sum + rest < target || sum - rest > target) {
                return;
            }
            dfs(i + 1, sum + nums[i]);
            dfs(i + 1, sum - nums[i]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}