package leetcode.editor.cn;

import java.util.Arrays;

//Java：三个无重叠子数组的最大和
public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        Solution solution = new MaximumSumOf3NonOverlappingSubarrays().new Solution();
        // TO TEST
        int[] arr = solution.maxSumOfThreeSubarrays(new int[]{4,3,2,1}, 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sumArr = new int[len];
        for (int i = 0; i < len; i++) {
            sumArr[i] = (i == 0 ? 0 : sumArr[i - 1]) + nums[i];
        }

        // dp[i][j]表示在i到len - 1中选择j个长度为k的子数组的最最大值和对应的index
        int[][][] dp = new int[len + 1][4][2];
        for (int j = 1; j <= 3; j++) {
            for (int i = len - k; i >= 0; i--) {
                dp[i][j][0] = dp[i + k][j - 1][0] + sumArr[i + k - 1] - (i - 1 >= 0 ? sumArr[i - 1] : 0);
                dp[i][j][1] = i;
                if (dp[i][j][0] < dp[i + 1][j][0]) {
                    dp[i][j][0] = dp[i + 1][j][0];
                    dp[i][j][1] = dp[i + 1][j][1];
                }
            }
        }

        int ans1 = dp[0][3][1], ans2 = dp[ans1 + k][2][1], ans3 = dp[ans2 + k][1][1];
        return new int[]{ans1, ans2, ans3};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}