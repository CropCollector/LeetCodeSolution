package leetcode.editor.cn;

//Java：括号的最大嵌套深度
public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth(String s) {
            int ans = 0, leftCount = 0, len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    leftCount ++;
                    ans = Math.max(ans, leftCount);
                } else if (c == ')') {
                    leftCount --;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}