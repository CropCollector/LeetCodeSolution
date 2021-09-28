package leetcode.editor.cn;

//Java：最后一个单词的长度
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = true;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    continue;
                } else {
                    break;
                }
            } else {
                if (flag) {
                    flag = false;
                }
                ans ++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}