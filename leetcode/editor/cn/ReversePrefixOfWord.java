package leetcode.editor.cn;

//Java：反转单词前缀
public class ReversePrefixOfWord {
    public static void main(String[] args) {
        Solution solution = new ReversePrefixOfWord().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reversePrefix(String word, char ch) {
            int index = word.indexOf(ch);
            if (index == -1) {
                return word;
            }
            return new StringBuffer(word.substring(0, index + 1)).reverse()
                    .append(word.substring(index + 1)).toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}