//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 178 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeyboardRow{
  public static void main(String[] args) {
       Solution solution = new KeyboardRow().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            String s = rows[i];
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), i);
            }
        }

        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String s = words[i].toLowerCase();
            int r = map.get(s.charAt(0));
            boolean toAdd = true;
            for (int j = 1; j < s.length(); j++) {
                if (map.get(s.charAt(j)) != r) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd) {
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
