package leetcode.editor.cn;

//Java：重复叠加字符串匹配
public class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        StringBuffer asb = new StringBuffer();
        int ans = 0;
        while (asb.length() <= aLen * 2 + bLen) {
            if (asb.indexOf(b) != -1) {
                return ans;
            }
            asb.append(a);
            ans ++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}