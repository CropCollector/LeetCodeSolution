package leetcode.editor.cn;

import java.util.*;

//Java：正则表达式匹配
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        //拆分匹配字符串p
        Stack<String> ps = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                ps.add(ps.pop() + "*");
            } else {
                ps.add(String.valueOf(c));
            }
        }
        String[] pArr = ps.toArray(new String[ps.size()]);

        boolean[][] dp = new boolean[s.length()][pArr.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 0; i < dp.length; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < pArr.length; j++) {
                String reg = pArr[j];
                // i j <- i-1 j | i-1 j-1 | i j-1
                boolean flag;
                if (reg.equals(".") || reg.length() > 1) {
                    flag = true;
                } else {
                    flag = reg.equals(String.valueOf(c));
                }
                if (!flag) {
                    dp[i][j] = false;
                } else {
                    if (i - 1 >= 0) {
                        if (reg.length() == 1 || (reg.charAt(0) != c && reg.charAt(0) != '.')) {
                            flag = false;
                        } else {
                            flag = flag || dp[i - 1][j];
                        }
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        flag = flag || dp[i - 1][j - 1];
                    }
                    if (j - 1 >= 0) {
                        if (pArr[j - 1].length() == 1) {
                            flag = false;
                        } else {
                            flag = flag || dp[i][j - 1];
                        }
                    }
                    dp[i][j] = flag;
                }
            }
        }
        return dp[s.length() - 1][pArr.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}