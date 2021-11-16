//给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。 
//
// 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。 
//
// 由于答案可能很大，只需要返回 答案 mod 10⁹ + 7 的值。 
//
// 示例 1: 
//
// 
//输入: n = 3, k = 0
//输出: 1
//解释: 
//只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
// 
//
// 示例 2: 
//
// 
//输入: n = 3, k = 1
//输出: 2
//解释: 
//数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
// 
//
// 说明: 
//
// 
// n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。 
// 
// Related Topics 动态规划 👍 200 👎 0


package leetcode.editor.cn;
public class KInversePairsArray{
  public static void main(String[] args) {
       Solution solution = new KInversePairsArray().new Solution();
       System.out.println(solution.kInversePairs(3, 0));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = (int) (1e9 + 7);
        // dp[i][j]表示n=i时，k=j的排列组合数
        long[][] dp = new long[n + 1][k + 1];
        dp[1][0] = 1;
        //dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + ..dp[i - 1][j - (i - 1)]
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j ++) {
                int min = Math.max(0, j - i + 1);
                for (int l = min; l <= j ; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][l]) % MOD;
                }
            }
        }
        return (int)dp[n][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
