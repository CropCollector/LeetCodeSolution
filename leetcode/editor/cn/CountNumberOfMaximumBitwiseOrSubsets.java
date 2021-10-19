package leetcode.editor.cn;

//Java：统计按位或能得到最大值的子集数目
public class CountNumberOfMaximumBitwiseOrSubsets {

    public static void main(String[] args) {
        Solution solution = new CountNumberOfMaximumBitwiseOrSubsets().new Solution();
        // TO TEST
        System.out.println(solution.countMaxOrSubsets(new int[]{2,2,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int max = 0;

        private int ans = 0;

        public int countMaxOrSubsets(int[] nums) {
            for (int num : nums) {
                max = max | num;
            }
            dfs(nums, 0, 0);
            return ans;
        }

        private void dfs(int[] nums, int cur, int i) {
            if (cur == max) {
                int n = nums.length - i;
                ans += Math.pow(2, n);
                return;
            }
            if (i == nums.length) {
                return;
            }
            dfs(nums, cur | nums[i], i + 1);
            dfs(nums, cur, i + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}