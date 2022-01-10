package leetcode.editor.cn;

import java.util.Arrays;

//Java：跳跃游戏 II
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        // TO TEST
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 1; i < len; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    // 不可达
                    if (dp[j] == Integer.MAX_VALUE || nums[j] < i - j) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}