package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Arrays;

//Java：分割等和子集
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        // TO TEST
        System.out.println(solution.canPartition(new int[]{1,5,10,6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            int sum = 0, max = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if ((sum & 1) == 1) {
                return false;
            }
            sum >>= 1;

            if (max > sum) {
                return false;
            }
            int len = nums.length;
            // dp[i][j] 定义为[0,i] 范围内的子数组和是否可以正好等于j
            boolean[][] dp = new boolean[len][sum + 1];
            dp[0][0] = dp[0][nums[0]] = true;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= sum; j++) {
                    dp[i][j] = dp[i - 1][j] || (j < nums[i] ? false : dp[i - 1][j - nums[i]]);
                }
            }
            return dp[len - 1][sum];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}