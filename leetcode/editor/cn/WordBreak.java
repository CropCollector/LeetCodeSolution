package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//Java：单词拆分
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        // TO TEST
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>(wordDict);
            int len = s.length();
            // dp[i]表示s中[0, i]的子字符串是否可以由wordDict组成
            boolean[] dp = new boolean[len];
            for (int i = 0; i < len; i++) {
                for (int j = i; j >= 0; j--) {
                    dp[i] = (j > 0 ? dp[j - 1] : true) && set.contains(s.substring(j, i + 1));
                    if (dp[i]) break;
                }
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}