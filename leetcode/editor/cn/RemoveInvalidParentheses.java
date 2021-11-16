//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 605 👎 0


package leetcode.editor.cn;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        System.out.println(solution.removeInvalidParentheses(")(f"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            Set<String> curSet = new HashSet<>();
            curSet.add(s);
            while (true) {
                for (String str : curSet) {
                    if (isValid(str)) {
                        ans.add(str);
                    }
                }
                if (!ans.isEmpty()) {
                    return ans;
                }
                Set<String> nextSet = new HashSet<>();
                for (String str : curSet) {
                    for (int i = 0; i < str.length(); i++) {
                        if (Character.isLetter(str.charAt(i))) continue;
                        nextSet.add(str.substring(0, i) + str.substring(i + 1, str.length()));
                    }
                }
                curSet = nextSet;
            }
        }

        private boolean isValid(String s) {
            int lCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    lCount ++;
                } else if (c == ')') {
                    lCount --;
                    if (lCount < 0) {
                        return false;
                    }
                }
            }
            return lCount == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
