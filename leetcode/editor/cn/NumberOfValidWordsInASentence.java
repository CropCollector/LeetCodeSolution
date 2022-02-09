package leetcode.editor.cn;

//Java：句子中的有效单词数
public class NumberOfValidWordsInASentence {
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsInASentence().new Solution();
        // TO TEST
        System.out.println(solution.countValidWords("v-"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countValidWords(String sentence) {
        int ans = 0;
        String[] arr = sentence.split(" ");
        next :
        for (String s : arr) {
            if (s.length() == 0) {
                continue;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    continue next;
                }
                if ((c == '!' || c == '.' || c == ',') && i != s.length() - 1) {
                    continue next;
                }
                int index = s.indexOf("-");
                if (index != -1) {
                    if (index == 0 || index == s.length() - 1) {
                        continue next;
                    } else {
                        String s1 = s.substring(0, index);
                        String s2 = s.substring(index + 1);
                        if (s1.length() == 0 || s2.length() == 0 || s2.indexOf("-") != -1 ||
                                (s2.length() == 1 && !Character.isLetter(s2.charAt(0)))) {
                            continue next;
                        }
                    }
                }
            }
            ans ++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}