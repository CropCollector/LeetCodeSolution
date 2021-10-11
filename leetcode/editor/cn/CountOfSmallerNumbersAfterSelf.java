package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：计算右侧小于当前元素的个数
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        // TO TEST
        System.out.println(solution.countSmaller(new int[]{2,0,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i --) {
            for (int j = i + 1; j < n; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : dp) {
            ans.add(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}