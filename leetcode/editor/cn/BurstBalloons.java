package leetcode.editor.cn;

import java.util.Arrays;

//Java：戳气球
public class BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
        // TO TEST
        System.out.println(solution.maxCoins(new int[]{3,1,5,8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            int[] newNums = new int[nums.length + 2];
            System.arraycopy(nums, 0, newNums, 1, nums.length);
            int len = newNums.length;
            newNums[0] = newNums[len - 1] = 1;
            //dp[i][j] 表示开区间内i到j中可以获得的最大硬币数
            int[][] dp = new int[len][len];
            for (int size = 2; size < len; size++) {
                for (int i = 0; i + size < len; i++) {
                    for (int j = i + 1; j < i + size; j++) {
                        dp[i][i + size] = Math.max(dp[i][i + size], dp[i][j] + newNums[i] * newNums[j] * newNums[i + size] + dp[j][i + size]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}