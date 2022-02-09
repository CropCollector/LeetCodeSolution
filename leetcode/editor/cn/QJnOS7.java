package leetcode.editor.cn;

//Java：最长公共子序列
public class QJnOS7 {
    public static void main(String[] args) {
        Solution solution = new QJnOS7().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length(), len2 = text2.length();
            // dp[i][j] 表示text1.subString(0, i + 1) 和 text2.subString(0, j + 1)的最长公共子序列长度
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                char c1 = text1.charAt(i - 1);
                for (int j = 1; j <= len2; j++) {
                    char c2 = text2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1][len2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}