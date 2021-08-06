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
        int len = s.length();
        int startIndex = 0, endIndex = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i < s.length(); j++) {
                int start = j, end = j + i;
                if (i == 1) {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = true;
                        startIndex = start;
                        endIndex = end;
                    } else {
                        dp[start][end] = false;
                    }
                } else {
                    if (dp[start + 1][end - 1]) {
                        if (s.charAt(start) == s.charAt(end)) {
                            dp[start][end] = true;
                            startIndex = start;
                            endIndex = end;
                        } else {
                            dp[start][end] = false;
                        }
                    } else {
                        dp[start][end] = false;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}