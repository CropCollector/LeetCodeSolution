package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：字母大小写全排列
public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
        // TO TEST
        solution.letterCasePermutation("a1b2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> ans = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            dfs(s, s.length(), new StringBuffer(), 0);
            return ans;
        }

        private void dfs(String s, int len, StringBuffer sb, int index) {
            if (sb.length() == len) {
                ans.add(sb.toString());
                return;
            }
            char c = s.charAt(index);
            if (Character.isLetter(c)) {
                // 小写
                sb.append(Character.toLowerCase(c));
                dfs(s, len, sb, index + 1);
                sb.deleteCharAt(index);

                // 大写
                sb.append(Character.toUpperCase(c));
                dfs(s, len, sb, index + 1);
                sb.deleteCharAt(index);
            } else {
                sb.append(c);
                dfs(s, len, sb, index + 1);
                sb.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}