package leetcode.editor.cn;

//Java：回文子串
public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            ans ++;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        dp[i][j] = true;
                        ans ++;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            ans ++;
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}