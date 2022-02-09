package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长等差数列
public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.longestArithSeqLength(new int[]{24,13,1,100,0,94,3,0,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int len = nums.length, ans = -1;
            // dp[i] key：与当前nums[i]的公差 value：该公差组成的等差数量长度
            Map<Integer, Integer>[] dp = new Map[len];
            for (int i = 0; i < len; i++) {
                dp[i] = new HashMap();
                for (int j = i - 1; j >= 0; j--) {
                    int d = nums[i] - nums[j];
                    int count = dp[j].getOrDefault(d, 0) + 1;
                    dp[i].put(d, Math.max(dp[i].getOrDefault(d, 0), count));
                    ans = Math.max(ans, dp[i].get(d));
                }
            }
            return ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}