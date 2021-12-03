package leetcode.editor.cn;

import java.util.Arrays;

//Java：不同的二叉搜索树
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        // TO TEST
        System.out.println(solution.numTrees(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}