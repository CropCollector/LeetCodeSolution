package leetcode.editor.cn;

//Java：反转字符串
public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j;) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i ++;
            j --;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}