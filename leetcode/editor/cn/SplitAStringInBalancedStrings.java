package leetcode.editor.cn;

//Java：分割平衡字符串
public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        Solution solution = new SplitAStringInBalancedStrings().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, lCount = 0, rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                lCount ++;
            } else {
                rCount ++;
            }
            if (lCount == rCount) {
                lCount = rCount = 0;
                ans ++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}