package leetcode.editor.cn;

//Java：最少移动次数使数组元素相等 II
public class MinimumMovesToEqualArrayElementsIi {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElementsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves2(int[] nums) {
            int len = nums.length;
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                long tmp = 0;
                for (int j = 0; j < len; j++) {
                    tmp += Math.abs(nums[i] - nums[j]);
                }
                ans = Math.min(tmp, ans);
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}