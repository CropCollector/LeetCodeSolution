package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int n;

        private List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            this.n = n;
            dfs("",0, 0);
            return ans;
        }

        private void dfs(String s, int leftCount, int rightCount) {
            if (leftCount > n || rightCount > n) {
                return;
            } else if (leftCount == n && leftCount == rightCount) {
                ans.add(s);
                return;
            }
            dfs(s + "(", leftCount + 1, rightCount);
            if (leftCount > rightCount) {
                dfs(s + ")", leftCount, rightCount + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}