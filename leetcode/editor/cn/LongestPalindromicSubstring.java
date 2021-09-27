package leetcode.editor.cn;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 1, start = 0, end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        dp[i][j] = true;
                        if (max < 2) {
                            start = i;
                            end = j;
                            max = 2;
                        }
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            if (max < j - i + 1) {
                                start = i;
                                end = j;
                                max = j - i + 1;
                            }
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}