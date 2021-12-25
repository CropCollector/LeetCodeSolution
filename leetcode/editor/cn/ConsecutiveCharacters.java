package leetcode.editor.cn;

//Java：连续字符
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        Solution solution = new ConsecutiveCharacters().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPower(String s) {
        int len = s.length(), ans = 1, curCount = 1;
        char cur = s.charAt(0);
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == cur) {
                curCount ++;
                ans = Math.max(ans, curCount);
            } else {
                cur = c;
                curCount = 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}