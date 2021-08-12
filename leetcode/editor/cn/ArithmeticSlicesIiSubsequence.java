package leetcode.editor.cn;

import sun.security.pkcs11.Secmod;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java：等差数列划分 II - 子序列
public class ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlicesIiSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.numberOfArithmeticSlices(new int[]{7,7,7,7,7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        HashMap<Long, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                HashMap<Long, Integer> map = dp[j];
                Long sub = (long) (nums[i]) - (long) (nums[j]);
                Integer count = map.getOrDefault(sub, 0);
                ans += count;
                dp[i].put(sub, dp[i].getOrDefault(sub, 0) + count + 1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}