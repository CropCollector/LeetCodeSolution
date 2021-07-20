package leetcode.editor.cn;

//Java：反转字符串中的单词 III
public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ss.length; i++) {
            sb.append(reverseString(ss[i].toCharArray()));
            if (i != ss.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public char[] reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j;) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i ++;
            j --;
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}