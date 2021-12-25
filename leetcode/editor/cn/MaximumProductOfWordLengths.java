//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 
//输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// Related Topics 位运算 数组 字符串 👍 288 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

public class MaximumProductOfWordLengths{
  public static void main(String[] args) {
       Solution solution = new MaximumProductOfWordLengths().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 1; i < len; i++) {
            set.clear();
            String s1 = words[i];
            int s1Len = s1.length();
            for (int j = 0; j < s1Len; j++) {
                set.add(s1.charAt(j));
            }
            for (int j = 0; j < i; j++) {
                String s2 = words[j];
                int s2Len = s2.length();
                boolean suc = true;
                for (int k = 0; k < s2Len; k++) {
                    if (set.contains(s2.charAt(k))) {
                        suc = false;
                        break;
                    }
                }
                if (suc) {
                    ans = Math.max(ans, s1Len * s2Len);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
