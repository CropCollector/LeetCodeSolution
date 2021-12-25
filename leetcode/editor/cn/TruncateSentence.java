package leetcode.editor.cn;

//Java：截断句子
public class TruncateSentence {
    public static void main(String[] args) {
        Solution solution = new TruncateSentence().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String truncateSentence(String s, int k) {
        int count = 0, len = s.length();
        int index;
        for (index = 0; index < len; index++) {
            if (s.charAt(index) == ' ') {
                count ++;
            }
            if (count == k) {
                break;
            }
        }
        return s.substring(0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}